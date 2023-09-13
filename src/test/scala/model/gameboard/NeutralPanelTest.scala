package cl.uchile.dcc.citric
package model.gameboard

import cl.uchile.dcc.citric.model.units.PlayerCharacter
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class NeutralPanelTest extends FunSuite {
  var player1: PlayerCharacter = _
  var player2: PlayerCharacter = _
  var neutral: NeutralPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10,5, 5, 0)
    player2 = new PlayerCharacter("Kira", 7, 6, 9, 1, 6)
    neutral = new NeutralPanel
  }

  test("Add character to a neutral panel"){
    val expectedNothing : ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter : ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertEquals(neutral.characters, expectedNothing)
    assertNotEquals(neutral.characters, expectedCharacter)
    neutral.addCharacter(player1)
    assertNotEquals(neutral.characters, expectedNothing)
    assertEquals(neutral.characters, expectedCharacter)
  }

  test("Remove character from a neutral panel") {
    neutral.addCharacter(player1)
    neutral.addCharacter(player2)
    val expectedNothing: ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter1: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1,player2)
    assertNotEquals(neutral.characters, expectedNothing)
    assertNotEquals(neutral.characters, expectedCharacter1)
    assertNotEquals(neutral.characters, expectedCharacter2)
    assertEquals(neutral.characters, expectedCharacters)
    neutral.removeCharacter(player1)
    assertNotEquals(neutral.characters, expectedNothing)
    assertNotEquals(neutral.characters, expectedCharacter1)
    assertEquals(neutral.characters, expectedCharacter2)
    assertNotEquals(neutral.characters, expectedCharacters)
  }

}
