package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class EncounterPanelTest extends FunSuite {
  var player1: PlayerCharacter = _
  var player2: PlayerCharacter = _
  var encounter: EncounterPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10,5, 5, 0, 2, 50, 5, 1)
    player2 = new PlayerCharacter("Kira", 7, 6, 9, 1, 6, 1, 20, 2, 0)
    encounter = new EncounterPanel
  }

  test("Add character to a neutral panel"){
    val expectedNothing : ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter : ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertEquals(encounter.characters, expectedNothing)
    assertNotEquals(encounter.characters, expectedCharacter)
    encounter.addCharacter(player1)
    assertNotEquals(encounter.characters, expectedNothing)
    assertEquals(encounter.characters, expectedCharacter)
  }

  test("Remove character from a neutral panel") {
    encounter.addCharacter(player1)
    encounter.addCharacter(player2)
    val expectedNothing: ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter1: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1,player2)
    assertNotEquals(encounter.characters, expectedNothing)
    assertNotEquals(encounter.characters, expectedCharacter1)
    assertNotEquals(encounter.characters, expectedCharacter2)
    assertEquals(encounter.characters, expectedCharacters)
    encounter.removeCharacter(player1)
    assertNotEquals(encounter.characters, expectedNothing)
    assertNotEquals(encounter.characters, expectedCharacter1)
    assertEquals(encounter.characters, expectedCharacter2)
    assertNotEquals(encounter.characters, expectedCharacters)
  }

}
