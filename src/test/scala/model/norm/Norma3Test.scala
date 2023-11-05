package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma3Test extends munit.FunSuite {
  private var norma: Norma3 = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma3
    player = new PlayerCharacter("Molly", 5, 1, 1, 0)
  }

  test("Norma3 boost to Norma4 by stars objective") {
    player.increaseStars(200)
    player.changeRoad(1)
    assert(norma.checkBoost(player).isInstanceOf[Norma4])
  }

  test("Norma3 boost to Norma4 by victories objective") {
    player.increaseVictories(14)
    player.changeRoad(2)
    assert(norma.checkBoost(player).isInstanceOf[Norma4])
  }

  test("Norma3 don't boost to Norma4 by stars objective") {
    player.changeRoad(1)
    assert(norma.checkBoost(player).isInstanceOf[Norma3])
  }

  test("Norma3 don't boost to Norma4 by victories objective") {
    player.changeRoad(2)
    assert(norma.checkBoost(player).isInstanceOf[Norma3])
  }

  test("Norma3 give his value as an int") {
    val value: Int = norma.toNumber()
    assertEquals(value, 3)
  }
}
