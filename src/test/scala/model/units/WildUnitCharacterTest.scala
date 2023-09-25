package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacterTest extends munit.FunSuite{
  private val name = "WildUnit"
  private val maxHp = 5
  private var currHp = 5
  private val attack = 0
  private val defense = 0
  private val evasion = 0
  private var currStars = 0
  private var randomNumberGenerator: Random = _

  private var wildUnit1: WildUnitCharacter = _
  private var wildUnit2: WildUnitCharacter = _
  private var wildUnit3: WildUnitCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    wildUnit1 = new WildUnitCharacter(name, maxHp, currHp, attack, defense, evasion, currStars,randomNumberGenerator)
    wildUnit2 = new WildUnitCharacter(name, maxHp, 4, attack, defense, evasion, 11)
    wildUnit3 = new WildUnitCharacter(name, maxHp, 1, attack, defense, evasion, currStars, randomNumberGenerator)
  }

  test("A wild unit should have correctly set their attributes"){
    assertEquals(wildUnit1.name, name)
    assertEquals(wildUnit1.maxHp, maxHp)
    assertEquals(wildUnit1.currHp, currHp)
    assertEquals(wildUnit1.attack, attack)
    assertEquals(wildUnit1.defense, defense)
    assertEquals(wildUnit1.evasion, evasion)
    assertEquals(wildUnit1.currStars, currStars)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A wild unit should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(wildUnit1.rollDice >= 1 && wildUnit1.rollDice <= 6)
    }
  }

  // 2. Set a seed and test the result is always the same.
  // A seed sets a fixed succession of random numbers, so you can know that the next numbers
  // are always the same for the same seed.
  test("A wild unit should be able to roll a dice with a fixed seed") {
    val other1 =
      new WildUnitCharacter(name, maxHp, currHp, attack, defense, evasion, currStars, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(wildUnit1.rollDice(), other1.rollDice())
    }
  }

  test("A character should automatically have a randomNumberGenerator to work in a dice"){
    val randomWildUnitTestValue: Int = wildUnit2.randomNumberGenerator.nextInt(6) + 1
    assert(randomWildUnitTestValue >=1 && randomWildUnitTestValue <= 6)
  }

  test("A wild unit should be able to increase his value of stars, without limits") {
    val valueToGive: Int = 10
    val expectedStars: Int = wildUnit1.currStars + valueToGive
    wildUnit1.increaseStars(valueToGive)
    assertEquals(wildUnit1.currStars, expectedStars)
  }

  test("A wild unit should be able to decrease his value of stars, without overflow the 0") {
    val valueToDrop: Int = 10
    // This case should overflow
    val expectedStars1: Int = wildUnit1.currStars - valueToDrop
    wildUnit1.decreaseStars(valueToDrop)
    assertNotEquals(wildUnit1.currStars, expectedStars1)
    // This case shouldn´t overflow
    val expectedStars2: Int = wildUnit2.currStars - valueToDrop
    wildUnit2.decreaseStars(valueToDrop)
    assertEquals(wildUnit2.currStars, expectedStars2)
  }

  test("A character should be able to increase his currHp, without overflow maxHp") {
    val valueToIncrease: Int = 1
    // This case should overflow
    val expectedHp1: Int = wildUnit1.currHp + valueToIncrease
    wildUnit1.increaseHp(valueToIncrease)
    assertNotEquals(wildUnit1.currHp, expectedHp1)
    // This case shouldn't overflow
    val expectedHp2: Int = wildUnit2.currHp + valueToIncrease
    wildUnit2.increaseHp(valueToIncrease)
    assertEquals(wildUnit2.currHp, expectedHp2)
  }

  test("A character should be able to decrease his currHp, without overflow the 0") {
    val valueToDecrease: Int = 2
    // This case should overflow
    val expectedHp1: Int = wildUnit1.currHp - valueToDecrease
    wildUnit1.decreaseHp(valueToDecrease)
    assertEquals(wildUnit1.currHp, expectedHp1)
    // This case shouldn't overflow
    val expectedHp2: Int = wildUnit3.currHp - valueToDecrease
    wildUnit3.decreaseHp(valueToDecrease)
    assertNotEquals(wildUnit3.currHp, expectedHp2)
  }

}
