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

  test("Add character to drop panel") {
    val expectedCharacter: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertNotEquals(drop.characters, expectedCharacter)
    drop.addCharacter(player1)
    assertEquals(drop.characters, expectedCharacter)
  }

  test("Remove character from a drop panel") {
    drop.addCharacter(player1)
    drop.addCharacter(player2)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1, player2)
    assertNotEquals(drop.characters, expectedCharacter2)
    assertEquals(drop.characters, expectedCharacters)
    drop.removeCharacter(player1)
    assertEquals(drop.characters, expectedCharacter2)
    assertNotEquals(drop.characters, expectedCharacters)
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
