package cl.uchile.dcc.citric
package model.units

class RoboBallTest extends munit.FunSuite{
  private val name = "RoboBall"
  private val maxHp = 3
  private val attack = -1
  private val defense = 1
  private val evasion = -1
  private var chicken: Chicken = _
  private var roboBall1: RoboBall = _
  private var player: PlayerCharacter = _
  private var roboBall: RoboBall = _
  private var seagull: Seagull = _

  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken()
    roboBall1 = new RoboBall()
    player = new PlayerCharacter("Molly", 5, 1, 1, 0)
    roboBall = new RoboBall()
    seagull = new Seagull()
  }

  test("A roboBall should have correctly set their attributes") {
    assertEquals(roboBall.name, name)
    assertEquals(roboBall.maxHp, maxHp)
    assertEquals(roboBall.attack, attack)
    assertEquals(roboBall.defense, defense)
    assertEquals(roboBall.evasion, evasion)
    assertEquals(roboBall.currStars, 2)
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

  test("A roboBall should be able to give his final number damage by avoid at the duel") {
    // both characters roll dice, with values -> 1 <= value <=6
    val value: Int = roboBall.rollDice()
    val value1: Int = roboBall1.rollDice()
    // roboBall will attack
    val finalAttack: Int = roboBall.attackCharacter(value)

    // roboBall will avoid
    val finalAvoid: Int = roboBall.avoidCharacter(finalAttack, value)
    assert(finalAvoid == 0 || finalAvoid == finalAttack)

    // roboBall1 will avoid
    val finalAvoid1: Int = roboBall1.avoidCharacter(finalAttack, value1)
    assert(finalAvoid1 == 0 || finalAvoid1 == finalAttack)
  }

  test("RoboBall lose stars against a Player") {
    roboBall.increaseStars(33)
    player.increaseStars(11)
    val charStars: Int = roboBall.currStars
    val char1Stars: Int = player.currStars
    val expectedValue: Int = 0
    val expectedValue1: Int = charStars + char1Stars
    roboBall.loseStarsAgainst(player)
    assertEquals(roboBall.currStars, expectedValue)
    assertEquals(player.currStars, expectedValue1)
  }

  test("RoboBall lose stars against a Chicken") {
    roboBall.increaseStars(33)
    chicken.increaseStars(11)
    val charStars: Int = roboBall.currStars
    val char1Stars: Int = chicken.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    roboBall.loseStarsAgainst(chicken)
    assertEquals(roboBall.currStars, expectedValue)
    assertEquals(chicken.currStars, expectedValue1)
  }

  test("RoboBall lose stars against a RoboBall") {
    roboBall.increaseStars(33)
    roboBall1.increaseStars(11)
    val charStars: Int = roboBall.currStars
    val char1Stars: Int = roboBall1.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    roboBall.loseStarsAgainst(roboBall1)
    assertEquals(roboBall.currStars, expectedValue)
    assertEquals(roboBall1.currStars, expectedValue1)
  }

  test("RoboBall lose stars against a Seagull") {
    roboBall.increaseStars(33)
    seagull.increaseStars(11)
    val charStars: Int = roboBall.currStars
    val char1Stars: Int = seagull.currStars
    val expectedValue: Int = charStars
    val expectedValue1: Int = char1Stars
    roboBall.loseStarsAgainst(seagull)
    assertEquals(roboBall.currStars, expectedValue)
    assertEquals(seagull.currStars, expectedValue1)
  }

  test("RoboBall lose against a Player") {
    val charVictories: Int = player.currVictories + 1
    roboBall.loseAgainst(player)
    assertEquals(player.currVictories, charVictories)
  }

  test("RoboBall lose against a Chicken") {
    roboBall.loseAgainst(chicken)
  }

  test("Roboball lose against a RoboBall") {
    roboBall.loseAgainst(roboBall1)
  }

  test("RoboBall lose against a Seagull") {
    roboBall.loseAgainst(seagull)
  }
}
                              