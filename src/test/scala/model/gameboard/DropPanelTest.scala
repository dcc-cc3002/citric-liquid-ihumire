package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class DropPanelTest extends FunSuite {
  var player1: PlayerCharacter = _
  var player2: PlayerCharacter = _
  var drop: DropPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10,5, 5, 0, 2, 50, 5, 1)
    player2 = new PlayerCharacter("Kira", 7, 6, 9, 1, 6, 1, 20, 2, 0)
    drop = new DropPanel
  }

  test("Drop stars by a character in a bonus panel (p1 version"){
    val roll: Int = player1.rollDice()
    val toDrop: Int = math.min(roll * player1.currNorma, roll * 3)
    val expectedStars: Int = player1.currStars - toDrop
    drop.dropStars(player1, roll)
    assertEquals(player1.currStars, expectedStars)
  }

  test("Drop stars by a character in a bonus panel (p2 version)") {
    val roll: Int = player2.rollDice()
    val toDrop: Int = roll * player2.currNorma
    val expectedStars: Int = player2.currStars - toDrop
    drop.dropStars(player2, roll)
    assertEquals(player2.currStars, expectedStars)
  }
}
