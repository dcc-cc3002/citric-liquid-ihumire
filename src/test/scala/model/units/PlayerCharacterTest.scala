package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {

  private val name = "testPlayer"
  private val maxHp = 5
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator: Random = _

  private var character: PlayerCharacter = _
  private var character1: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character = new PlayerCharacter(name, maxHp, attack, defense, evasion)
    character1 = new PlayerCharacter(name, maxHp, attack, defense, evasion,randomNumberGenerator)
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

  test("A character should be able to set a road of stars (1)"){
    val expectedRoad: Int = 1
    character.changeRoad(1)
    assertEquals(character.currRoad, expectedRoad)
  }

  test("A character should be able to set a road of victories (2)") {
    val expectedRoad: Int = 2
    character.changeRoad(2)
    assertEquals(character.currRoad, expectedRoad)
  }

  test("A character should be able to set his level of norma") {
    val expectedNorma: Int = 2
    character.advanceToNorma(2)
    assertEquals(character.currNorma, expectedNorma)
  }

  test("A character should be able to increase his victories, without limits") {
    val expectedVictories: Int = character.currVictories + 1
    character.increaseVictories(1)
    assertEquals(character.currVictories, expectedVictories)
  }

  test("A character should be able to NormaClear by all the stars road") {
    character.increaseStars(200)

    val expected1: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected1)

    val expected2: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected2)

    val expected3: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected3)

    val expected4: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected4)

    val expected5: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected5)
  }

  test ("A character should be able to NormaClear by all the victories road") {
    character.changeRoad(2)
    character.increaseVictories(14)

    val expected1: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected1)

    val expected2: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected2)

    val expected3: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected3)

    val expected4: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected4)

    val expected5: Int = character.currNorma + 1
    character.normaClear()
    assertEquals(character.currNorma, expected5)
  }

  test("A character should be able to not being knockedOut when his currHp is not 0") {
    val expected: Boolean = true
    character.knockPlayer()
    assertNotEquals(character.knockedOut, expected)
  }

  test("A character should be able to knockedOut when his currHp is 0"){
    character.decreaseHp(5)
    val expected: Boolean = true
    character.knockPlayer()
    assertEquals(character.knockedOut, expected)
  }
}
