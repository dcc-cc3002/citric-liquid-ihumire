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

  test("A character should be able to increase his value of stars") {
    val valueToGive: Int = 10
    val expectedStars: Int = character.currStars + valueToGive
    character.increaseStars(valueToGive)
    assertEquals(character.currStars, expectedStars)
  }

  test("A character should be able to decrease his value of stars") {
    val valueToDrop: Int = 10
    val expectedStars: Int = character.currStars - valueToDrop
    character.decreaseStars(valueToDrop)
    assertEquals(character.currStars, expectedStars)
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
