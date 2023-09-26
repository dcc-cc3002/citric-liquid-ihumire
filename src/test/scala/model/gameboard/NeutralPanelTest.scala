package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter
import scala.collection.mutable.ArrayBuffer
import munit.FunSuite

class NeutralPanelTest extends FunSuite {
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _
  private var neutral: NeutralPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10, 5, 5, 0, 2, 50, 5, 1)
    player2 = new PlayerCharacter("Kira", 7, 6, 9, 1, 6, 1, 20, 2, 0)
    neutral = new NeutralPanel
  }

  test("Add character to neutral panel") {
    val expectedCharacter: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertNotEquals(neutral.characters, expectedCharacter)
    neutral.addCharacter(player1)
    assertEquals(neutral.characters, expectedCharacter)
  }

  test("Remove character from a neutral panel") {
    neutral.addCharacter(player1)
    neutral.addCharacter(player2)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1, player2)
    assertNotEquals(neutral.characters, expectedCharacter2)
    assertEquals(neutral.characters, expectedCharacters)
    neutral.removeCharacter(player1)
    assertEquals(neutral.characters, expectedCharacter2)
    assertNotEquals(neutral.characters, expectedCharacters)
  }

}
