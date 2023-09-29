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
  /*
  private var character1: PlayerCharacter = _
  private var character2: PlayerCharacter = _
  private var character3: PlayerCharacter = _
  private var testCharStarRoad1: PlayerCharacter = _
  private var testCharStarRoad2: PlayerCharacter = _
  private var testCharStarRoad3: PlayerCharacter = _
  private var testCharStarRoad4: PlayerCharacter = _
  private var testCharStarRoad5: PlayerCharacter = _
  private var testCharVictoryRoad1: PlayerCharacter = _
  private var testCharVictoryRoad2: PlayerCharacter = _
  private var testCharVictoryRoad3: PlayerCharacter = _
  private var testCharVictoryRoad4: PlayerCharacter = _
  private var testCharVictoryRoad5: PlayerCharacter = _ */
  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character = new PlayerCharacter(name, maxHp, attack, defense, evasion)
    /*
    character1 = new PlayerCharacter(
      name, 10, 9, attack, defense, evasion,
      currNorma, 11,currVictories,currRoad,randomNumberGenerator)
    character2 = new PlayerCharacter(
      name, 10, 1, attack, defense, evasion,
      currNorma, currStars, currVictories, currRoad, randomNumberGenerator)
    character3 = new PlayerCharacter(
      name, maxHp, 0, attack, defense, evasion,
      currNorma, currStars, currVictories, currRoad, randomNumberGenerator)
    testCharStarRoad1 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      1, 10, currVictories, 1, randomNumberGenerator)
    testCharStarRoad2 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      2, 30, currVictories, 1, randomNumberGenerator)
    testCharStarRoad3 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      3, 70, currVictories, 1, randomNumberGenerator)
    testCharStarRoad4 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      4, 120, currVictories, 1, randomNumberGenerator)
    testCharStarRoad5 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      5, 200, currVictories, 1, randomNumberGenerator)
    testCharVictoryRoad1 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      1, currStars, 1, 2, randomNumberGenerator)
    testCharVictoryRoad2 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      2, currStars, 3, 2, randomNumberGenerator)
    testCharVictoryRoad3 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      3, currStars, 6, 2, randomNumberGenerator)
    testCharVictoryRoad4 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      4, currStars, 10, 2, randomNumberGenerator)
    testCharVictoryRoad5 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      5, currStars, 14, 2, randomNumberGenerator)*/
  }

  test("A character should have correctly set their attributes") {
    val randomCharacterTestValue: Int = character.randomNumberGenerator.nextInt(6) + 1
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
    assert(randomCharacterTestValue >= 1 && randomCharacterTestValue <= 6)
  }

  test("A character should be able to set his level of norma") {
    val expectedNorma: Int = 2
    character.advanceToNorma(2)
    assertEquals(character.currNorma, expectedNorma)
  }

  test("A character should be able to increase his value of stars, without limits") {
    val valueToGive: Int = 10
    val expectedStars: Int = character.currStars + valueToGive
    character.increaseStars(valueToGive)
    assertEquals(character.currStars, expectedStars)
  }
/*
  test("A character should be able to decrease his value of stars, without overflow the 0") {
    val valueToDrop: Int = 10
    // This case should overflow
    val expectedStars: Int = character.currStars - valueToDrop
    character.decreaseStars(valueToDrop)
    assertNotEquals(character.currStars, expectedStars)
    // This case shouldn´t overflow
    val expectedStars1: Int = character1.currStars - valueToDrop
    character1.decreaseStars(valueToDrop)
    assertEquals(character1.currStars, expectedStars1)
  }
  
 */
/*
  test("A character should be able to increase his currHp, without overflow maxHp") {
    val valueToIncrease: Int = 1
    // This case should overflow
    val expectedHp: Int = character.currHp + valueToIncrease
    character.increaseHp(valueToIncrease)
    assertNotEquals(character.currHp, expectedHp)
    // This case shouldn't overflow
    val expectedHp1: Int = character1.currHp + valueToIncrease
    character1.increaseHp(valueToIncrease)
    assertEquals(character1.currHp, expectedHp1)
  }

  test("A character should be able to decrease his currHp, without overflow the 0") {
    val valueToDecrease: Int = 2
    // This case should overflow
    val expectedHp: Int = character.currHp - valueToDecrease
    character.decreaseHp(valueToDecrease)
    assertEquals(character.currHp, expectedHp)
    // This case shouldn't overflow
    val expectedHp1: Int = character2.currHp - valueToDecrease
    character2.decreaseHp(valueToDecrease)
    assertNotEquals(character2.currHp, expectedHp1)
  }

  test("A character should be able to increase his victories, without limits") {
    val expectedVictories: Int = character.currVictories + 1
    character.increaseVictory()
    assertEquals(character.currVictories, expectedVictories)
  }

  test("A character should be able to NormaClear by all the stars road") {

    val expected1: Int = testCharStarRoad1.currNorma + 1
    testCharStarRoad1.normaClear()
    assertEquals(testCharStarRoad1.currNorma,expected1)

    val expected2: Int = testCharStarRoad2.currNorma + 1
    testCharStarRoad2.normaClear()
    assertEquals(testCharStarRoad2.currNorma, expected2)

    val expected3: Int = testCharStarRoad3.currNorma + 1
    testCharStarRoad3.normaClear()
    assertEquals(testCharStarRoad3.currNorma, expected3)

    val expected4: Int = testCharStarRoad4.currNorma + 1
    testCharStarRoad4.normaClear()
    assertEquals(testCharStarRoad4.currNorma, expected4)

    val expected5: Int = testCharStarRoad5.currNorma + 1
    testCharStarRoad5.normaClear()
    assertEquals(testCharStarRoad5.currNorma, expected5)
  }

  test ("A character should be able to NormaClear by all the victories road") {

    val expected1: Int = testCharVictoryRoad1.currNorma + 1
    testCharVictoryRoad1.normaClear()
    assertEquals(testCharVictoryRoad1.currNorma, expected1)

    val expected2: Int = testCharVictoryRoad2.currNorma + 1
    testCharVictoryRoad2.normaClear()
    assertEquals(testCharVictoryRoad2.currNorma, expected2)

    val expected3: Int = testCharVictoryRoad3.currNorma + 1
    testCharVictoryRoad3.normaClear()
    assertEquals(testCharVictoryRoad3.currNorma, expected3)

    val expected4: Int = testCharVictoryRoad4.currNorma + 1
    testCharVictoryRoad4.normaClear()
    assertEquals(testCharVictoryRoad4.currNorma, expected4)

    val expected5: Int = testCharVictoryRoad5.currNorma + 1
    testCharVictoryRoad5.normaClear()
    assertEquals(testCharVictoryRoad5.currNorma, expected5)
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
      new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion, currNorma, currStars, currVictories, currRoad, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(character1.rollDice(), other.rollDice())
    }
  }

  test("A character should be able to knockedOut"){
    val expected: Boolean = true
    character.shouldKnockedOut()
    assertNotEquals(character.knockedOut, expected)
    character3.shouldKnockedOut()
    assertEquals(character3.knockedOut, expected)
  */
}
