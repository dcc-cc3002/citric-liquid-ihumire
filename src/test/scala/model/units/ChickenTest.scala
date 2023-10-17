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

  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken()
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
}
