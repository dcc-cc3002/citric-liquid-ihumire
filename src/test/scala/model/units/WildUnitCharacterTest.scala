package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacterTest extends munit.FunSuite{
/*
  private val name = "WildUnit"
  private val maxHp = 3
  private val attack = 0
  private val defense = 0
  private val evasion = 0
  private val attack1 = -2
  private val defense1 = -2
  private val evasion1 = -2
  private var randomNumberGenerator: Random = _

  private var wildUnit: WildUnitCharacter = _
  private var wildUnit1: WildUnitCharacter = _


  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    wildUnit = new WildUnitCharacter(name, maxHp, attack, defense, evasion)
    wildUnit1 = new WildUnitCharacter(name, maxHp, attack1, defense1, evasion1, randomNumberGenerator)
  }

  test("A wild unit should have correctly set their attributes"){
    assertEquals(wildUnit.name, name)
    assertEquals(wildUnit.maxHp, maxHp)
    assertEquals(wildUnit.attack, attack)
    assertEquals(wildUnit.defense, defense)
    assertEquals(wildUnit.evasion, evasion)
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

  test("A wildUnit should be able to give his final number of attack for the duel") {
    // case having a positive number
    val value: Int = wildUnit.rollDice() // value >= 1 && value <= 6
    val expectedValue: Int = value + wildUnit.attack
    val finalAttack: Int = wildUnit.attackCharacter(value)
    assertEquals(finalAttack, expectedValue)

    // case having a number less equal to zero
    val value1: Int = wildUnit1.rollDice() // value >= 1 && value <= 6
    val expectedValue1: Int = value1 + wildUnit1.attack
    val finalAttack1: Int = wildUnit1.attackCharacter(value)
    assertNotEquals(finalAttack1, expectedValue1)
  }

  test("A wildUnit should be able to give his final number of defend for the duel") {
    // both wildUnits roll dice, with values -> 1 <= value <=6
    val value: Int = wildUnit.rollDice()
    val value1: Int = wildUnit1.rollDice()
    // wildUnit will attack
    val finalAttack: Int = wildUnit.attackCharacter(value)
    // wildUnit1 will avoid
    val expectedValue: Int = math.max(1, finalAttack - (value1 + wildUnit1.defense))
    val finalDefend: Int = wildUnit1.defendCharacter(finalAttack, value1)
    assertEquals(finalDefend, expectedValue)
  }

  test("A wildUnit should be able to give his final number of avoid for the duel") {
    // both wildUnits roll dice, with values -> 1 <= value <=6
    val value: Int = wildUnit.rollDice()
    val value1: Int = wildUnit1.rollDice()
    // wildUnit will attack
    val finalAttack: Int = wildUnit.attackCharacter(value)
    // wildUnit1 will avoid
    val expectedValue: Int = math.max(0, finalAttack - (value1 + wildUnit1.evasion))
    val finalAvoid: Int = wildUnit1.avoidCharacter(finalAttack, value1)
    assertEquals(finalAvoid, expectedValue)
  }
 */
}
