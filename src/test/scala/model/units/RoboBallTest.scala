package cl.uchile.dcc.citric
package model.units

class RoboBallTest extends munit.FunSuite{
  private val name = "RoboBall"
  private val maxHp = 3
  private val attack = -1
  private val defense = 1
  private val evasion = -1
  private var roboBall: RoboBall = _
  private var roboBall1: RoboBall = _

  override def beforeEach(context: BeforeEach): Unit = {
    roboBall = new RoboBall()
    roboBall1 = new RoboBall()
  }

  test("A roboBall should have correctly set their attributes") {
    assertEquals(roboBall.name, name)
    assertEquals(roboBall.maxHp, maxHp)
    assertEquals(roboBall.attack, attack)
    assertEquals(roboBall.defense, defense)
    assertEquals(roboBall.evasion, evasion)
  }

  test("A roboBall should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(roboBall.rollDice >= 1 && roboBall.rollDice <= 6)
    }
  }

  test("A roboBall automatically have a randomNumberGenerator to work in a dice") {
    val randomChickenTest: Int = roboBall.randomNumberGenerator.nextInt(6) + 1
    assert(randomChickenTest >= 1 && randomChickenTest <= 6)
  }

  test("A roboBall should be able to increase his value of stars, without limits") {
    val valueToGive: Int = 10
    val expectedStars: Int = roboBall.currStars + valueToGive
    roboBall.increaseStars(valueToGive)
    assertEquals(roboBall.currStars, expectedStars)
  }

  test("A roboBall should be able to decrease his value of stars, without overflow the 0") {
    val valueToDrop: Int = 10
    val expectedStars: Int = roboBall.currStars - valueToDrop
    roboBall.decreaseStars(valueToDrop)
    assertNotEquals(roboBall.currStars, expectedStars)
  }

  test("A roboBall should be able to decrease his value of stars, doing a normal reduce") {
    roboBall.increaseStars(12)
    val valueToDrop: Int = 10
    val expectedStarsReduce: Int = roboBall.currStars - valueToDrop
    roboBall.decreaseStars(valueToDrop)
    assertEquals(roboBall.currStars, expectedStarsReduce)
  }

  test("A roboBall should be able to decrease his currHp, without overflow 0") {
    val valueToDecrease: Int = 6
    val expectedHp: Int = roboBall.currHp - valueToDecrease
    roboBall.decreaseHp(valueToDecrease)
    assertNotEquals(roboBall.currHp, expectedHp)
  }

  test("A roboBall should be able to decrease his currHp, doing a normal reduce") {
    val valueToDecrease: Int = 2
    val expectedHp: Int = roboBall.currHp - valueToDecrease
    roboBall.decreaseHp(valueToDecrease)
    assertEquals(roboBall.currHp, expectedHp)
  }

  test("A roboBall should be able to increase his currHp, without overflow maxHp") {
    val valueToIncrease: Int = 1
    val expectedHp: Int = roboBall.currHp + valueToIncrease
    roboBall.increaseHp(valueToIncrease)
    assertNotEquals(roboBall.currHp, expectedHp)
  }

  test("A roboBall should be able to increase his currHp, doing a normal addition") {
    roboBall.decreaseHp(2)
    val valueToIncrease: Int = 1
    val expectedHp: Int = roboBall.currHp + valueToIncrease
    roboBall.increaseHp(valueToIncrease)
    assertEquals(roboBall.currHp, expectedHp)
  }

  test("A roboBall should be able to not being killed when his currHp is not 0") {
    val expected: Boolean = true
    roboBall.knockCharacter()
    assertNotEquals(roboBall.knockedOut, expected)
  }

  test("A roboBall should be able to death when his currHp is 0") {
    roboBall.decreaseHp(3)
    val expected: Boolean = true
    roboBall.knockCharacter()
    assertEquals(roboBall.knockedOut, expected)
  }

  test("A roboBall should be able to give his final number of attack for the duel") {
    for (x <- 1 to 6) {
      val value: Int = x
      val expectedValue: Int = value + roboBall.attack
      val finalAttack: Int = roboBall.attackCharacter(value)
      assertEquals(finalAttack, expectedValue)
    }
  }

  test("A roboBall should be able to give his final number damage at the duel") {
    for (x <- 1 to 6){
      val value: Int = x
      // roboBall will attack
      val finalAttack: Int = roboBall.attackCharacter(value)
      for (y <- 1 to 6){
        val value1: Int = y
        // roboBall1 will defend
        val expectedValue: Int = math.max(1, finalAttack - (value1 + roboBall1.defense))
        val finalDefend: Int = roboBall1.defendCharacter(finalAttack, value1)
        assertEquals(finalDefend, expectedValue)
      }
    }
  }
/*
  test("A roboBall should be able to give his final number damage at the duel") {
    for (x <- 1 to 6) {
      val value: Int = x
      // roboBall will attack
      val finalAttack: Int = roboBall.attackCharacter(value)
      for (y <- 1 to 6){
        val value1: Int = y
        // roboBall 1 will defend
        val finalAvoid: Int = roboBall1.avoidCharacter(finalAttack, value1)
        assertEquals(finalAvoid,finalAttack)
      }
    }
  }*/
}
                              