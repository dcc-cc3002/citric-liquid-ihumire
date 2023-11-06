package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class ChickenTest extends munit.FunSuite{
  private val name = "Chicken"
  private val maxHp = 3
  private val attack = -1
  private val defense = -1
  private val evasion = 1
  private var chicken: Chicken = _
  private var chicken1: Chicken = _
  private var player: PlayerCharacter = _
  private var roboBall: RoboBall = _
  private var seagull: Seagull = _
  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken()
    chicken1 = new Chicken()
    player = new PlayerCharacter("Molly", 5, 1, 1, 0)
    roboBall = new RoboBall()
    seagull = new Seagull()
  }

  test("A chicken should have correctly set their attributes") {
    assertEquals(chicken.name, name)
    assertEquals(chicken.maxHp, maxHp)
    assertEquals(chicken.attack, attack)
    assertEquals(chicken.defense, defense)
    assertEquals(chicken.evasion, evasion)
    assertEquals(chicken.currStars,3)
  }

  test("A chicken should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(chicken.rollDice >= 1 && chicken.rollDice <= 6)
    }
  }

  test("A chicken automatically have a randomNumberGenerator to work in a dice") {
    val randomChickenTest: Int = chicken.randomNumberGenerator.nextInt(6) + 1
    assert(randomChickenTest >= 1 && randomChickenTest <= 6)
  }

  test("A chicken should be able to increase his value of stars, without limits") {
    val valueToGive: Int = 10
    val expectedStars: Int = chicken.currStars + valueToGive
    chicken.increaseStars(valueToGive)
    assertEquals(chicken.currStars, expectedStars)
  }

  test("A chicken should be able to decrease his value of stars, without overflow the 0") {
    val valueToDrop: Int = 10
    val expectedStars: Int = chicken.currStars - valueToDrop
    chicken.decreaseStars(valueToDrop)
    assertNotEquals(chicken.currStars, expectedStars)
  }

  test("A chicken should be able to decrease his value of stars, doing a normal reduce") {
    chicken.increaseStars(12)
    val valueToDrop: Int = 10
    val expectedStarsReduce: Int = chicken.currStars - valueToDrop
    chicken.decreaseStars(valueToDrop)
    assertEquals(chicken.currStars, expectedStarsReduce)
  }

  test("A chicken should be able to decrease his currHp, without overflow 0") {
    val valueToDecrease: Int = 6
    val expectedHp: Int = chicken.currHp - valueToDecrease
    chicken.decreaseHp(valueToDecrease)
    assertNotEquals(chicken.currHp, expectedHp)
  }

  test("A chicken should be able to decrease his currHp, doing a normal reduce") {
    val valueToDecrease: Int = 2
    val expectedHp: Int = chicken.currHp - valueToDecrease
    chicken.decreaseHp(valueToDecrease)
    assertEquals(chicken.currHp, expectedHp)
  }

  test("A chicken should be able to increase his currHp, without overflow maxHp") {
    val valueToIncrease: Int = 1
    val expectedHp: Int = chicken.currHp + valueToIncrease
    chicken.increaseHp(valueToIncrease)
    assertNotEquals(chicken.currHp, expectedHp)
  }

  test("A chicken should be able to increase his currHp, doing a normal addition") {
    chicken.decreaseHp(2)
    val valueToIncrease: Int = 1
    val expectedHp: Int = chicken.currHp + valueToIncrease
    chicken.increaseHp(valueToIncrease)
    assertEquals(chicken.currHp, expectedHp)
  }

  test("A chicken should be able to give his final number of attack for the duel") {
    for (x <- 1 to 6) {
      val value: Int = x
      val expectedValue: Int = value + chicken.attack
      val finalAttack: Int = chicken.attackCharacter(value)
      assertEquals(finalAttack, expectedValue)
    }
  }

  test("A chicken should be able to give his final number damage by defend at the duel") {
    for (x <- 1 to 6){
      val value: Int = x
      // chicken will attack
      val finalAttack: Int = chicken.attackCharacter(value)
      for (y <- 1 to 6){
        val value1: Int = y
        // chicken1 will defend
        val expectedValue: Int = math.max(1, finalAttack - (value1 + chicken1.defense))
        val finalDefend: Int = chicken1.defendCharacter(finalAttack, value1)
        assertEquals(finalDefend, expectedValue)
      }
    }
  }

  test("A chicken should be able to give his final number damage by avoid at the duel") {
    // both characters roll dice, with values -> 1 <= value <=6
    val value: Int = chicken.rollDice()
    val value1: Int = chicken1.rollDice()
    // chicken will attack
    val finalAttack: Int = chicken.attackCharacter(value)

    // chicken will avoid
    val finalAvoid: Int = chicken.avoidCharacter(finalAttack, value)
    assert(finalAvoid == 0 || finalAvoid == finalAttack)

    // chicken will avoid
    val finalAvoid1: Int = chicken1.avoidCharacter(finalAttack, value1)
    assert(finalAvoid1 == 0 || finalAvoid1 == finalAttack)
  }

  test("Chicken lose stars against a Player") {
    chicken.increaseStars(33)
    player.increaseStars(11)
    val charStars: Int = chicken.currStars
    val char1Stars: Int = player.currStars
    val expectedValue: Int = 0
    val expectedValue1: Int = charStars + char1Stars
    chicken.loseStarsAgainst(player)
    assertEquals(chicken.currStars, expectedValue)
    assertEquals(player.currStars, expectedValue1)
  }

  test("Chicken lose stars against a chicken") {
    chicken.increaseStars(33)
    chicken1.increaseStars(11)
    val charStars: Int = chicken.currStars
    val char1Stars: Int = chicken1.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    chicken.loseStarsAgainst(chicken1)
    assertEquals(chicken.currStars, expectedValue)
    assertEquals(chicken1.currStars, expectedValue1)
  }

  test("Chicken lose stars against a RoboBall") {
    chicken.increaseStars(33)
    roboBall.increaseStars(11)
    val charStars: Int = chicken.currStars
    val char1Stars: Int = roboBall.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    chicken.loseStarsAgainst(roboBall)
    assertEquals(chicken.currStars, expectedValue)
    assertEquals(roboBall.currStars, expectedValue1)
  }

  test("Chicken lose stars against a Seagull") {
    chicken.increaseStars(33)
    seagull.increaseStars(11)
    val charStars: Int = chicken.currStars
    val char1Stars: Int = seagull.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    chicken.loseStarsAgainst(seagull)
    assertEquals(chicken.currStars, expectedValue)
    assertEquals(seagull.currStars, expectedValue1)
  }

  test("Chicken lose against a Player") {
    val charVictories: Int = player.currVictories + 1
    chicken.loseAgainst(player)
    assertEquals(player.currVictories, charVictories)
  }

  test("Chicken lose against a Chicken") {
    chicken.loseAgainst(chicken1)
  }

  test("Chicken lose against a RoboBall") {
    chicken.loseAgainst(roboBall)
  }

  test("Chicken lose against a Seagull") {
    chicken.loseAgainst(seagull)
  }

  test("A chicken should be able to not being knockedOut when his currHp is not 0") {
    val expected: Boolean = true
    chicken.knockCharacter()
    assertNotEquals(chicken.knockedOut, expected)
  }
  test("A player should be able to knockedOut when his currHp is 0") {
    chicken.decreaseHp(3)
    val expected: Boolean = true
    chicken.knockCharacter()
    assertEquals(chicken.knockedOut, expected)
  }

  test("A chicken have to transfer stars to the player who beats him") {
    chicken.increaseStars(33)
    player.increaseStars(11)
    val charStars: Int = chicken.currStars
    val char1Stars: Int = player.currStars
    val expectedValue: Int = 0
    val expectedValue1: Int = charStars + char1Stars
    chicken.decreaseHp(3)
    chicken.transferStarsTo(player)
    assertEquals(chicken.currStars, expectedValue)
    assertEquals(player.currStars, expectedValue1)
  }

  test("A chicken haven't transfer stars to the chicken who beats him") {
    chicken.increaseStars(33)
    chicken1.increaseStars(11)
    val charStars: Int = chicken.currStars
    val char1Stars: Int = chicken1.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    chicken.decreaseHp(3)
    chicken.transferStarsTo(chicken1)
    assertEquals(chicken.currStars, expectedValue)
    assertEquals(chicken1.currStars, expectedValue1)
  }

  test("A chicken haven't transfer stars to the roboBall who beats him") {
    chicken.increaseStars(33)
    roboBall.increaseStars(11)
    val charStars: Int = chicken.currStars
    val char1Stars: Int = roboBall.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    chicken.decreaseHp(3)
    chicken.transferStarsTo(roboBall)
    assertEquals(chicken.currStars, expectedValue)
    assertEquals(roboBall.currStars, expectedValue1)
  }

  test("A chicken haven't transfer stars to the seagull who beats him") {
    chicken.increaseStars(33)
    seagull.increaseStars(11)
    val charStars: Int = chicken.currStars
    val char1Stars: Int = seagull.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    chicken.decreaseHp(3)
    chicken.transferStarsTo(seagull)
    assertEquals(chicken.currStars, expectedValue)
    assertEquals(seagull.currStars, expectedValue1)
  }

  test("A chicken have to give victories to the player who beats him") {
    val charVictories: Int = player.currVictories + 1
    chicken.decreaseHp(3)
    chicken.giveVicTo(player)
    assertEquals(player.currVictories, charVictories)
  }

  test("A chicken haven't to give victories to the chicken who beats him") {
    chicken.decreaseHp(3)
    chicken.loseAgainst(chicken1)
  }

  test("A chicken haven't to give victories to the roboBall who beats him") {
    chicken.decreaseHp(3)
    chicken.loseAgainst(roboBall)
  }

  test("A chicken haven't to give victories to the seagull who beats him") {
    chicken.decreaseHp(3)
    chicken.loseAgainst(seagull)
  }
}
                              