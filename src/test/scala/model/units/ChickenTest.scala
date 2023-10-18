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

  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken()
    chicken1 = new Chicken()
  }

  test("A chicken should have correctly set their attributes") {
    assertEquals(chicken.name, name)
    assertEquals(chicken.maxHp, maxHp)
    assertEquals(chicken.attack, attack)
    assertEquals(chicken.defense, defense)
    assertEquals(chicken.evasion, evasion)
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

  test("A chicken should be able to not being killed when his currHp is not 0") {
    val expected: Boolean = true
    chicken.killWildUnit()
    assertNotEquals(chicken.death, expected)
  }

  test("A chicken should be able to death when his currHp is 0") {
    chicken.decreaseHp(3)
    val expected: Boolean = true
    chicken.killWildUnit()
    assertEquals(chicken.death, expected)
  }

  test("A chicken should be able to give his final number of attack for the duel") {
    for (x <- 1 to 6) {
      val value: Int = x
      val expectedValue: Int = value + chicken.attack
      val finalAttack: Int = chicken.attackCharacter(value)
      assertEquals(finalAttack, expectedValue)
    }
  }

  test("A chicken should be able to give his final number damage at the duel") {
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

  test("A chicken should be able to give his final number damage at the duel") {
    for (x <- 1 to 6) {
      val value: Int = x
      // chicken will attack
      val finalAttack: Int = chicken.attackCharacter(value)
      for (y <- 1 to 6){
        val value1: Int = y
        // chicken 1 will defend
        val finalAvoid: Int = chicken1.avoidCharacter(finalAttack, value1)
        assertEquals(finalAvoid,finalAttack)
      }
    }
  }
}
                              