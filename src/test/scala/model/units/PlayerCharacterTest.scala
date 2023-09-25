package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name = "testPlayer"
  private val maxHp = 10
  var currHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  var currNorma = 1
  var currStars = 0
  var currVictories = 0
  var currRoad = 0
  private var randomNumberGenerator: Random = _
  /* Add any other constants you need here... */

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  /* Add any other variables you need here... */

  private var character1: PlayerCharacter = _
  private var character2: PlayerCharacter = _
  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character = new PlayerCharacter(
      name,
      maxHp,
      currHp,
      attack,
      defense,
      evasion,
      currNorma,
      currStars,
      currVictories,
      currRoad,
      randomNumberGenerator
    )
    character1 = new PlayerCharacter(
      name,
      10,
      9,
      attack,
      defense,
      evasion,
      currNorma,
      11,
      currVictories,
      currRoad,
      randomNumberGenerator
    )
    character2 = new PlayerCharacter(
      name,
      10,
      1,
      attack,
      defense,
      evasion,
      currNorma,
      currStars,
      currVictories,
      currRoad,
      randomNumberGenerator
    )
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.currHp, currHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
    assertEquals(character.currNorma, currNorma)
    assertEquals(character.currStars, currStars)
    assertEquals(character.currVictories, currVictories)
    assertEquals(character.currRoad, currRoad)
  }

  test("A character should be able to increase his level of norma") {
    val expectedNorma: Int = character.currNorma + 1
    character.advanceNorma()
    assertEquals(character.currNorma, expectedNorma)
  }

  test("A character should be able to increase his value of stars, without limits") {
    val valueToGive: Int = 10
    val expectedStars: Int = character.currStars + valueToGive
    character.increaseStars(valueToGive)
    assertEquals(character.currStars, expectedStars)
  }

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

    var testCharacter1 = new PlayerCharacter(name,maxHp,currHp,attack,defense,evasion,
      1,10,currVictories,1,randomNumberGenerator)
    val expected1: Int = testCharacter1.currNorma + 1
    testCharacter1.normaClear()
    assertEquals(testCharacter1.currNorma,expected1)

    var testCharacter2 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      2, 30, currVictories, 1, randomNumberGenerator)
    val expected2: Int = testCharacter2.currNorma + 1
    testCharacter2.normaClear()
    assertEquals(testCharacter2.currNorma, expected2)

    var testCharacter3 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      3, 70, currVictories, 1, randomNumberGenerator)
    val expected3: Int = testCharacter3.currNorma + 1
    testCharacter3.normaClear()
    assertEquals(testCharacter3.currNorma, expected3)

    var testCharacter4 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      4, 120, currVictories, 1, randomNumberGenerator)
    val expected4: Int = testCharacter4.currNorma + 1
    testCharacter4.normaClear()
    assertEquals(testCharacter4.currNorma, expected4)

    var testCharacter5 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      5, 200, currVictories, 1, randomNumberGenerator)
    val expected5: Int = testCharacter5.currNorma + 1
    testCharacter5.normaClear()
    assertEquals(testCharacter5.currNorma, expected5)
  }

  test ("A character should be able to NormaClear by all the victories road") {

    var testCharacter1 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      1, currStars, 1, 2, randomNumberGenerator)
    val expected1: Int = testCharacter1.currNorma + 1
    testCharacter1.normaClear()
    assertEquals(testCharacter1.currNorma, expected1)

    var testCharacter2 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      2, currStars, 3, 2, randomNumberGenerator)
    val expected2: Int = testCharacter2.currNorma + 1
    testCharacter2.normaClear()
    assertEquals(testCharacter2.currNorma, expected2)

    var testCharacter3 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      3, currStars, 6, 2, randomNumberGenerator)
    val expected3: Int = testCharacter3.currNorma + 1
    testCharacter3.normaClear()
    assertEquals(testCharacter3.currNorma, expected3)

    var testCharacter4 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      4, currStars, 10, 2, randomNumberGenerator)
    val expected4: Int = testCharacter4.currNorma + 1
    testCharacter4.normaClear()
    assertEquals(testCharacter4.currNorma, expected4)

    var testCharacter5 = new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion,
      5, currStars, 14, 2, randomNumberGenerator)
    val expected5: Int = testCharacter5.currNorma + 1
    testCharacter5.normaClear()
    assertEquals(testCharacter5.currNorma, expected5)
  }




  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  // 2. Set a seed and test the result is always the same.
  // A seed sets a fixed succession of random numbers, so you can know that the next numbers
  // are always the same for the same seed.
  test("A character should be able to roll a dice with a fixed seed") {
    val other =
      new PlayerCharacter(name, maxHp, currHp, attack, defense, evasion, currNorma, currStars, currVictories, currRoad, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(character.rollDice(), other.rollDice())
    }
  }

}
