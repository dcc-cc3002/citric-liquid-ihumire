package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class HomePanelTest extends FunSuite {
  var player1: PlayerCharacter = _
  var player2: PlayerCharacter = _
  var home: HomePanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10, 5, 5, 0)
    player2 = new PlayerCharacter("Kira", 7, 5, 9, 1, 6)
    home = new HomePanel
  }

  test("Add character to a home panel"){
    val expectedNothing : ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter : ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertEquals(home.characters, expectedNothing)
    assertNotEquals(home.characters, expectedCharacter)
    home.addCharacter(player1)
    assertNotEquals(home.characters, expectedNothing)
    assertEquals(home.characters, expectedCharacter)
  }

  test("Remove character from a home panel") {
    home.addCharacter(player1)
    home.addCharacter(player2)
    val expectedNothing: ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter1: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1,player2)
    assertNotEquals(home.characters, expectedNothing)
    assertNotEquals(home.characters, expectedCharacter1)
    assertNotEquals(home.characters, expectedCharacter2)
    assertEquals(home.characters, expectedCharacters)
    home.removeCharacter(player1)
    assertNotEquals(home.characters, expectedNothing)
    assertNotEquals(home.characters, expectedCharacter1)
    assertEquals(home.characters, expectedCharacter2)
    assertNotEquals(home.characters, expectedCharacters)
  }
  // heal and normaCheck

  test("Heal a character in a home panel"){
    home.addCharacter(player1)

  }
}
