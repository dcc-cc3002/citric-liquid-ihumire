package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma1Test extends munit.FunSuite {
  private var norma: Norma1 = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma1
    player = new PlayerCharacter("Molly", 5, 1, 1, 0)
  }

  test("Norma1 boost to Norma2 by stars objective") {
    player.increaseStars(200)
    player.changeRoad(1)
    assert(norma.checkBoost(player).isInstanceOf[Norma2])
  }

  test("Norma1 boost to Norma2 by victories objective") {
    player.increaseVictories(14)
    player.changeRoad(2)
    assert(norma.checkBoost(player).isInstanceOf[Norma2])
  }

  test("Norma1 don't boost to Norma2 by stars objective") {
    player.changeRoad(1)
    assert(norma.checkBoost(player).isInstanceOf[Norma1])
  }

  test("Norma1 don't boost to Norma2 by victories objective") {
    player.changeRoad(2)
    assert(norma.checkBoost(player).isInstanceOf[Norma1])
  }

  test("Norma1 give his value as an int") {
    val value: Int = norma.toNumber()
    assertEquals(value, 1)
  }
}