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
    wildUnit1 = new WildUnitCharacter(name, maxHp, currHp, attack, defense, evasion, currStars, randomNumberGenerator)
    wildUnit2 = new WildUnitCharacter(name, maxHp, currHp, attack, defense, evasion, currStars, randomNumberGenerator)
    wildUnit3 = new WildUnitCharacter(name, maxHp, currHp, attack, defense, evasion, currStars, randomNumberGenerator)
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
}
