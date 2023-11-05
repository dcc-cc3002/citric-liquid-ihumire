package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norm.{Norma1, Norma2, Norma3, Norma4, Norma5, Norma6}
import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {

  private val name = "testPlayer"
  private val maxHp = 5
  private val attack = 1
  private val defense = 1
  private val evasion = 6
  private val attack1 = -6
  private val defense1 = -1
  private val evasion1 = -2
  private var randomNumberGenerator: Random = _
  private var roadS: StarsRoad = _
  private var roadV: VictoriesRoad = _
  private var roadA: AllRoads = _

  private var character: PlayerCharacter = _
  private var character1: PlayerCharacter = _
  private var chicken: Chicken = _
  private var roboBall: RoboBall = _
  private var seagull: Seagull = _

  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character = new PlayerCharacter(name, maxHp, attack, defense, evasion)
    character1 = new PlayerCharacter(name, maxHp, attack1, defense1, evasion1,randomNumberGenerator)
    chicken = new Chicken()
    roboBall = new RoboBall()
    seagull = new Seagull()
    roadS = new StarsRoad
    roadV = new VictoriesRoad
    roadA = new AllRoads
  }

  test("A character should have correctly set their attributes and have a new randomNumber") {
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character1.rollDice >= 1 && character1.rollDice <= 6)
    }
  }

  // 2. Set a seed and test the result is always the same.
  // A seed sets a fixed succession of random numbers, so you can know that the next numbers
  // are always the same for the same seed.
  test("A character should be able to roll a dice with a fixed seed") {
    val other =
      new PlayerCharacter(name, maxHp, attack, defense, evasion, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(character1.rollDice(), other.rollDice())
    }
  }

  test("A character wild unit automatically have a randomNumberGenerator to work in a dice") {
    val randomCharacterTestValue: Int = character.randomNumberGenerator.nextInt(6) + 1
    assert(randomCharacterTestValue >= 1 && randomCharacterTestValue <= 6)
  }

  test("A character should be able to increase his value of stars, without limits") {
    val valueToGive: Int = 10
    val expectedStars: Int = character.currStars + valueToGive
    character.increaseStars(valueToGive)
    assertEquals(character.currStars, expectedStars)
  }

  test("A character should be able to decrease his value of stars, without overflow the 0") {
    val valueToDrop: Int = 10
    val expectedStars: Int = character.currStars - valueToDrop
    character.decreaseStars(valueToDrop)
    assertNotEquals(character.currStars, expectedStars)
  }

  test("A character should be able to decrease his value of stars, doing a normal reduce") {
    character.increaseStars(12)
    val valueToDrop: Int = 10
    val expectedStarsReduce: Int = character.currStars - valueToDrop
    character.decreaseStars(valueToDrop)
    assertEquals(character.currStars, expectedStarsReduce)
  }

  test("A character should be able to decrease his currHp, without overflow 0") {
    val valueToDecrease: Int = 6
    val expectedHp: Int = character.currHp - valueToDecrease
    character.decreaseHp(valueToDecrease)
    assertNotEquals(character.currHp, expectedHp)
  }

  test("A character should be able to decrease his currHp, doing a normal reduce") {
    val valueToDecrease: Int = 2
    val expectedHp: Int = character.currHp - valueToDecrease
    character.decreaseHp(valueToDecrease)
    assertEquals(character.currHp, expectedHp)
  }

  test("A character should be able to increase his currHp, without overflow maxHp") {
    val valueToIncrease: Int = 1
    val expectedHp: Int = character.currHp + valueToIncrease
    character.increaseHp(valueToIncrease)
    assertNotEquals(character.currHp, expectedHp)
  }

  test("A character should be able to increase his currHp, doing a normal addition") {
    character.decreaseHp(2)
    val valueToIncrease: Int = 1
    val expectedHp: Int = character.currHp + valueToIncrease
    character.increaseHp(valueToIncrease)
    assertEquals(character.currHp, expectedHp)
  }

  test("A character should be able to increase his victories, without limits") {
    val expectedVictories: Int = character.currVictories + 1
    character.increaseVictories(1)
    assertEquals(character.currVictories, expectedVictories)
  }

  test("A character should be able to give his final number of attack for the duel"){
    // case having a positive number
    val value: Int = character.rollDice() // value >= 1 && value <= 6
    val expectedValue: Int = value + character.attack
    val finalAttack: Int = character.attackCharacter(value)
    assertEquals(finalAttack, expectedValue)

    // case having a number less equal to zero
    val value1: Int = character1.rollDice() // value >= 1 && value <= 6
    val expectedValue1: Int = value1 + character1.attack
    val finalAttack1: Int = character1.attackCharacter(value)
    assertNotEquals(finalAttack1, expectedValue1)
  }

  test("A character should be able to give his final number of defend for the duel") {
    // both characters roll dice, with values -> 1 <= value <=6
    val value: Int = character.rollDice()
    val value1: Int = character1.rollDice()
    // character will attack
    val finalAttack: Int = character.attackCharacter(value)
    // character1 will avoid
    val expectedValue: Int = math.max(1, finalAttack - (value1 + character1.defense))
    val finalDefend: Int = character1.defendCharacter(finalAttack, value1)
    assertEquals(finalDefend, expectedValue)
  }

  test("A character should be able to give his final number damage by avoid at the duel") {
    // both characters roll dice, with values -> 1 <= value <=6
    val value: Int = character.rollDice()
    val value1: Int = character1.rollDice()
    // character will attack
    val finalAttack: Int = character.attackCharacter(value)

    // character will avoid
    val finalAvoid: Int = character.avoidCharacter(finalAttack, value)
    assert(finalAvoid == 0 || finalAvoid == finalAttack)

    // character1 will avoid
    val finalAvoid1: Int = character1.avoidCharacter(finalAttack, value1)
    assert(finalAvoid1 == 0 || finalAvoid1 == finalAttack)
  }

  test("Change to star road") {
    character.changeRoad(roadS)
    assert(character.currRoad.isInstanceOf[StarsRoad])
    character.changeRoad(roadS)
    assert(character.currRoad.isInstanceOf[StarsRoad])
  }

  test("Change to victories road") {
    character.changeRoad(roadV)
    assert(character.currRoad.isInstanceOf[VictoriesRoad])
    character.changeRoad(roadV)
    assert(character.currRoad.isInstanceOf[VictoriesRoad])
  }

  test("Change to all roads") {
    character.changeRoad(roadA)
    assert(character.currRoad.isInstanceOf[AllRoads])
    character.changeRoad(roadA)
    assert(character.currRoad.isInstanceOf[AllRoads])
  }

  test("A character clears his norma by star road") {
    character.increaseStars(200)
    character.changeRoad(roadS)
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma2])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma3])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma4])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma5])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma6])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma6])
  }

  test("A character clears his norma by victories road") {
    character.increaseVictories(14)
    character.changeRoad(roadV)
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma2])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma3])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma4])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma5])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma6])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma6])
  }

  test("A character clears his norma by all roads (Stars)") {
    character.increaseStars(200)
    character.changeRoad(roadA)
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma2])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma3])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma4])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma5])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma6])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma6])
  }

  test("A character clears his norma by all roads (victories)") {
    character.increaseVictories(14)
    character.changeRoad(roadA)
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma2])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma3])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma4])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma5])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma6])
    character.normaClear()
    assert(character.currNorma.isInstanceOf[Norma6])
  }

  test("A character gives his current norma as a number") {
    character.increaseStars(200)
    val value1: Int = character.normaToNumber()
    assertEquals(value1, 1)
    character.normaClear()
    val value2: Int = character.normaToNumber()
    assertEquals(value2, 2)
    character.normaClear()
    val value3: Int = character.normaToNumber()
    assertEquals(value3, 3)
    character.normaClear()
    val value4: Int = character.normaToNumber()
    assertEquals(value4, 4)
    character.normaClear()
    val value5: Int = character.normaToNumber()
    assertEquals(value5, 5)
    character.normaClear()
    val value6: Int = character.normaToNumber()
    assertEquals(value6, 6)
    character.normaClear()
  }

  test("Player lose against a Player"){
    character.increaseStars(33)
    character1.increaseStars(11)
    val charStars: Int = character.currStars
    val char1Stars: Int = character1.currStars
    val expectedValue: Int = charStars - math.floorDiv(charStars, 2)
    val expectedValue1: Int = char1Stars + math.floorDiv(charStars, 2)
    character.loseAgainst(character1)
    assertEquals(character.currStars, expectedValue)
    assertEquals(character1.currStars, expectedValue1)
  }

  test("Player lose against a Chicken") {
    character.increaseStars(33)
    chicken.increaseStars(11)
    val charStars: Int = character.currStars
    val char1Stars: Int = chicken.currStars
    val expectedValue: Int = charStars - math.floorDiv(charStars, 2)
    val expectedValue1: Int = char1Stars + math.floorDiv(charStars, 2)
    character.loseAgainst(chicken)
    assertEquals(character.currStars, expectedValue)
    assertEquals(chicken.currStars, expectedValue1)
  }

  test("Player lose against a RoboBall") {
    character.increaseStars(33)
    roboBall.increaseStars(11)
    val charStars: Int = character.currStars
    val char1Stars: Int = roboBall.currStars
    val expectedValue: Int = charStars - math.floorDiv(charStars, 2)
    val expectedValue1: Int = char1Stars + math.floorDiv(charStars, 2)
    character.loseAgainst(roboBall)
    assertEquals(character.currStars, expectedValue)
    assertEquals(roboBall.currStars, expectedValue1)
  }

  test("Player lose against a Seagull") {
    character.increaseStars(33)
    seagull.increaseStars(11)
    val charStars: Int = character.currStars
    val char1Stars: Int = seagull.currStars
    val expectedValue: Int = charStars - math.floorDiv(charStars, 2)
    val expectedValue1: Int = char1Stars + math.floorDiv(charStars, 2)
    character.loseAgainst(seagull)
    assertEquals(character.currStars, expectedValue)
    assertEquals(seagull.currStars, expectedValue1)
  }
}

