package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class BonusPanelTest extends FunSuite {
  var player1: PlayerCharacter = _
  var player2: PlayerCharacter = _
  var roll: Int = _
  var bonus: BonusPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10,5, 5, 0, 2, 50, 5, 1)
    player2 = new PlayerCharacter("Kira", 7, 6, 9, 1, 6, 1, 20, 2, 0)
    bonus = new BonusPanel
  }

  test("Add character to a bonus panel"){
    val expectedNothing : ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter : ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertEquals(bonus.characters, expectedNothing)
    assertNotEquals(bonus.characters, expectedCharacter)
    bonus.addCharacter(player1)
    assertNotEquals(bonus.characters, expectedNothing)
    assertEquals(bonus.characters, expectedCharacter)
  }

  test("Remove character from a bonus panel") {
    bonus.addCharacter(player1)
    bonus.addCharacter(player2)
    val expectedNothing: ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter1: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1,player2)
    assertNotEquals(bonus.characters, expectedNothing)
    assertNotEquals(bonus.characters, expectedCharacter1)
    assertNotEquals(bonus.characters, expectedCharacter2)
    assertEquals(bonus.characters, expectedCharacters)
    bonus.removeCharacter(player1)
    assertNotEquals(bonus.characters, expectedNothing)
    assertNotEquals(bonus.characters, expectedCharacter1)
    assertEquals(bonus.characters, expectedCharacter2)
    assertNotEquals(bonus.characters, expectedCharacters)
  }

  test("Give stars to a character in a bonus panel (p1 version"){
    val roll: Int = player1.rollDice()
    val toGive: Int = math.min(roll * player1.currNorma, roll * 3)
    val expectedStars: Int = player1.currStars + toGive
    bonus.giveStars(player1, roll)
    assertEquals(player1.currStars, expectedStars)
  }

  test("Give stars to a character in a bonus panel (p2 version)") {
    val roll: Int = player2.rollDice()
    val toGive: Int = math.min(roll * player2.currNorma, roll * 3)
    val expectedStars: Int = player2.currStars + toGive
    bonus.giveStars(player2, roll)
    assertEquals(player2.currStars, expectedStars)
  }
}
