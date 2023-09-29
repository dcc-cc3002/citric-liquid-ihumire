package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacterTest extends munit.FunSuite{

  private val name = "WildUnit"
  private val maxHp = 3
  private val attack = 0
  private val defense = 0
  private val evasion = 0
  private var randomNumberGenerator: Random = _

  private var wildUnit: WildUnitCharacter = _
  private var wildUnit1: WildUnitCharacter = _


  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    wildUnit = new WildUnitCharacter(name, maxHp, attack, defense, evasion)
    wildUnit1 = new WildUnitCharacter(name, maxHp, attack, defense, evasion, randomNumberGenerator)
  }

  test("A wild unit should have correctly set their attributes"){
    assertEquals(wildUnit1.name, name)
    assertEquals(wildUnit1.maxHp, maxHp)
    assertEquals(wildUnit1.attack, attack)
    assertEquals(wildUnit1.defense, defense)
    assertEquals(wildUnit1.evasion, evasion)
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
      new WildUnitCharacter(name, maxHp, attack, defense, evasion, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(wildUnit1.rollDice(), other1.rollDice())
    }
  }

  test("A wild unit automatically have a randomNumberGenerator to work in a dice"){
    val randomWildUnitTestValue: Int = wildUnit1.randomNumberGenerator.nextInt(6) + 1
    assert(randomWildUnitTestValue >=1 && randomWildUnitTestValue <= 6)
  }

  test("A wild unit should be able to increase his value of stars, without limits") {
    val valueToGive: Int = 10
    val expectedStars: Int = wildUnit.currStars + valueToGive
    wildUnit.increaseStars(valueToGive)
    assertEquals(wildUnit.currStars, expectedStars)
  }

  test("A wild unit should be able to decrease his value of stars, without overflow the 0") {
    val valueToDrop: Int = 10
    val expectedStars: Int = wildUnit.currStars - valueToDrop
    wildUnit.decreaseStars(valueToDrop)
    assertNotEquals(wildUnit.currStars, expectedStars)
  }

  test("A wild unit should be able to decrease his value of stars, doing a normal reduce") {
    wildUnit.increaseStars(12)
    val valueToDrop: Int = 10
    val expectedStarsReduce: Int = wildUnit.currStars - valueToDrop
    wildUnit.decreaseStars(valueToDrop)
    assertEquals(wildUnit.currStars, expectedStarsReduce)
  }

  test("A wild unit should be able to decrease his currHp, without overflow 0") {
    val valueToDecrease: Int = 6
    val expectedHp: Int = wildUnit.currHp - valueToDecrease
    wildUnit.decreaseHp(valueToDecrease)
    assertNotEquals(wildUnit.currHp, expectedHp)
  }

  test("A wild unit should be able to decrease his currHp, doing a normal reduce") {
    val valueToDecrease: Int = 2
    val expectedHp: Int = wildUnit.currHp - valueToDecrease
    wildUnit.decreaseHp(valueToDecrease)
    assertEquals(wildUnit.currHp, expectedHp)
  }

  test("A wild unit should be able to increase his currHp, without overflow maxHp") {
    val valueToIncrease: Int = 1
    val expectedHp: Int = wildUnit.currHp + valueToIncrease
    wildUnit.increaseHp(valueToIncrease)
    assertNotEquals(wildUnit.currHp, expectedHp)
  }

  test("A wild unit should be able to increase his currHp, doing a normal addition") {
    wildUnit.decreaseHp(2)
    val valueToIncrease: Int = 1
    val expectedHp: Int = wildUnit.currHp + valueToIncrease
    wildUnit.increaseHp(valueToIncrease)
    assertEquals(wildUnit.currHp, expectedHp)
  }

  test("A wild unit should be able to not being killed when his currHp is not 0") {
    val expected: Boolean = true
    wildUnit.killWildUnit()
    assertNotEquals(wildUnit.death, expected)
  }

  test("A wild unit should be able to death when his currHp is 0") {
    wildUnit.decreaseHp(3)
    val expected: Boolean = true
    wildUnit.killWildUnit()
    assertEquals(wildUnit.death, expected)
  }
}
