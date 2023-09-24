package cl.uchile.dcc.citric
package model.gameboard

import cl.uchile.dcc.citric.model.units.PlayerCharacter
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer

class AbstractPanelTest extends FunSuite {
  var player1: PlayerCharacter = _
  var player2: PlayerCharacter = _
  var abstractPanel: Panel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10, 5, 5, 0, 2, 50, 5, 1)
    player2 = new PlayerCharacter("Kira", 7, 6, 9, 1, 6, 1, 20, 2, 0)
    abstractPanel = new AbstractPanel{}
  }

  test("Add character to panel") {
    val expectedNothing: ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertEquals(abstractPanel.characters, expectedNothing)
    assertNotEquals(abstractPanel.characters, expectedCharacter)
    abstractPanel.addCharacter(player1)
    assertNotEquals(abstractPanel.characters, expectedNothing)
    assertEquals(abstractPanel.characters, expectedCharacter)
  }

  test("Remove character from a panel") {
    abstractPanel.addCharacter(player1)
    abstractPanel.addCharacter(player2)
    val expectedNothing: ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter1: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1, player2)
    assertNotEquals(abstractPanel.characters, expectedNothing)
    assertNotEquals(abstractPanel.characters, expectedCharacter1)
    assertNotEquals(abstractPanel.characters, expectedCharacter2)
    assertEquals(abstractPanel.characters, expectedCharacters)
    abstractPanel.removeCharacter(player1)
    assertNotEquals(abstractPanel.characters, expectedNothing)
    assertNotEquals(abstractPanel.characters, expectedCharacter1)
    assertEquals(abstractPanel.characters, expectedCharacter2)
    assertNotEquals(abstractPanel.characters, expectedCharacters)
  }

}