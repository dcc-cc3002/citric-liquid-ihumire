package cl.uchile.dcc.citric
package model.units

class SeagullTest extends munit.FunSuite{
  private val name = "Seagull"
  private val maxHp = 3
  private val attack = 1
  private val defense = -1
  private val evasion = -1
  private var seagull: Seagull = _
  private var seagull1: Seagull = _

  override def beforeEach(context: BeforeEach): Unit = {
    seagull = new Seagull()
    seagull1 = new Seagull()
  }

  test("A seagull should have correctly set their attributes") {
    assertEquals(seagull.name, name)
    assertEquals(seagull.maxHp, maxHp)
    assertEquals(seagull.attack, attack)
    assertEquals(seagull.defense, defense)
    assertEquals(seagull.evasion, evasion)
  }

  test("A seagull should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(seagull.rollDice >= 1 && seagull.rollDice <= 6)
    }
  }

  test("A seagull automatically have a randomNumberGenerator to work in a dice") {
    val randomChickenTest: Int = seagull.randomNumberGenerator.nextInt(6) + 1
    assert(randomChickenTest >= 1 && randomChickenTest <= 6)
  }

  test("A seagull should be able to increase his value of stars, without limits") {
    val valueToGive: Int = 10
    val expectedStars: Int = seagull.currStars + valueToGive
    seagull.increaseStars(valueToGive)
    assertEquals(seagull.currStars, expectedStars)
  }

  test("A seagull should be able to decrease his value of stars, without overflow the 0") {
    val valueToDrop: Int = 10
    val expectedStars: Int = seagull.currStars - valueToDrop
    seagull.decreaseStars(valueToDrop)
    assertNotEquals(seagull.currStars, expectedStars)
  }

  test("A seagull should be able to decrease his value of stars, doing a normal reduce") {
    seagull.increaseStars(12)
    val valueToDrop: Int = 10
    val expectedStarsReduce: Int = seagull.currStars - valueToDrop
    seagull.decreaseStars(valueToDrop)
    assertEquals(seagull.currStars, expectedStarsReduce)
  }

  test("A seagull should be able to decrease his currHp, without overflow 0") {
    val valueToDecrease: Int = 6
    val expectedHp: Int = seagull.currHp - valueToDecrease
    seagull.decreaseHp(valueToDecrease)
    assertNotEquals(seagull.currHp, expectedHp)
  }

  test("A seagull should be able to decrease his currHp, doing a normal reduce") {
    val valueToDecrease: Int = 2
    val expectedHp: Int = seagull.currHp - valueToDecrease
    seagull.decreaseHp(valueToDecrease)
    assertEquals(seagull.currHp, expectedHp)
  }

  test("A seagull should be able to increase his currHp, without overflow maxHp") {
    val valueToIncrease: Int = 1
    val expectedHp: Int = seagull.currHp + valueToIncrease
    seagull.increaseHp(valueToIncrease)
    assertNotEquals(seagull.currHp, expectedHp)
  }

  test("A seagull should be able to increase his currHp, doing a normal addition") {
    seagull.decreaseHp(2)
    val valueToIncrease: Int = 1
    val expectedHp: Int = seagull.currHp + valueToIncrease
    seagull.increaseHp(valueToIncrease)
    assertEquals(seagull.currHp, expectedHp)
  }

  test("A seagull should be able to not being killed when his currHp is not 0") {
    val expected: Boolean = true
    seagull.knockCharacter()
    assertNotEquals(seagull.knockedOut, expected)
  }

  test("A seagull should be able to death when his currHp is 0") {
    seagull.decreaseHp(3)
    val expected: Boolean = true
    seagull.knockCharacter()
    assertEquals(seagull.knockedOut, expected)
  }

  test("A seagull should be able to give his final number of attack for the duel") {
    for (x <- 1 to 6) {
      val value: Int = x
      val expectedValue: Int = value + seagull.attack
      val finalAttack: Int = seagull.attackCharacter(value)
      assertEquals(finalAttack, expectedValue)
    }
  }

  test("A seagull should be able to give his final number damage at the duel") {
    for (x <- 1 to 6){
      val value: Int = x
      // seagull will attack
      val finalAttack: Int = seagull.attackCharacter(value)
      for (y <- 1 to 6){
        val value1: Int = y
        // seagull1 will defend
        val expectedValue: Int = math.max(1, finalAttack - (value1 + seagull1.defense))
        val finalDefend: Int = seagull1.defendCharacter(finalAttack, value1)
        assertEquals(finalDefend, expectedValue)
      }
    }
  }
/*
  test("A seagull should be able to give his final number damage at the duel") {
    for (x <- 1 to 6) {
      val value: Int = x
      // seagull will attack
      val finalAttack: Int = seagull.attackCharacter(value)
      for (y <- 1 to 6){
        val value1: Int = y
        // seagull 1 will defend
        val finalAvoid: Int = seagull1.avoidCharacter(finalAttack, value1)
        assertEquals(finalAvoid,finalAttack)
      }
    }
  }*/
}
                              