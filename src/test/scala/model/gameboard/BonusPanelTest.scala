package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.norm.Norma1
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class BonusPanelTest extends FunSuite {
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _
  private var neutral: NeutralPanel = _
  private var home: HomePanel = _
  private var bonus: BonusPanel = _
  private var drop: DropPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 5, 1, 1, 0)
    player2 = new PlayerCharacter("Kira", 5, 1, -1, 1)
    neutral = new NeutralPanel
    home = new HomePanel(player1)
    bonus = new BonusPanel
    drop = new DropPanel
  }

  test("Add character to bonus panel") {
    val expectedCharacter: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertNotEquals(bonus.characters, expectedCharacter)
    bonus.addCharacter(player1)
    assertEquals(bonus.characters, expectedCharacter)
  }

  test("Remove character from a bonus panel") {
    bonus.addCharacter(player1)
    bonus.addCharacter(player2)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1, player2)
    assertNotEquals(bonus.characters, expectedCharacter2)
    assertEquals(bonus.characters, expectedCharacters)
    bonus.removeCharacter(player1)
    assertEquals(bonus.characters, expectedCharacter2)
    assertNotEquals(bonus.characters, expectedCharacters)
  }

  test("Add a panel to nextPanels in bonus panel, having at 3 max") {
    val expectedOnePanel: ArrayBuffer[Panel] = ArrayBuffer(neutral)
    val expectedTwoPanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home)
    val expectedThreePanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home, bonus)
    bonus.addPanel(neutral)
    assertEquals(bonus.nextPanels, expectedOnePanel)
    bonus.addPanel(home)
    assertEquals(bonus.nextPanels, expectedTwoPanels)
    bonus.addPanel(bonus)
    assertEquals(bonus.nextPanels, expectedThreePanels)
    /* Extra addition do nothing */
    bonus.addPanel(drop)
    assertEquals(bonus.nextPanels, expectedThreePanels)
  }

  test("Remove a panel to nextPanels in bonus panel") {
    bonus.addPanel(neutral)
    bonus.addPanel(home)
    bonus.addPanel(bonus)
    val expectedNoPanel: ArrayBuffer[Panel] = ArrayBuffer()
    val expectedOnePanel: ArrayBuffer[Panel] = ArrayBuffer(neutral)
    val expectedTwoPanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home)
    val expectedThreePanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home, bonus)
    assertEquals(bonus.nextPanels, expectedThreePanels)
    bonus.removePanel(bonus)
    assertEquals(bonus.nextPanels, expectedTwoPanels)
    bonus.removePanel(home)
    assertEquals(bonus.nextPanels, expectedOnePanel)
    bonus.removePanel(neutral)
    assertEquals(bonus.nextPanels, expectedNoPanel)
    /* Extra remove do nothing */
    bonus.removePanel(neutral)
    assertEquals(bonus.nextPanels, expectedNoPanel)
  }

  test("A bonus panel should be applied his action to a character"){
    val notExpectedValue: Int = player1.currStars
    bonus.apply(player1)
    assert(notExpectedValue < player1.currStars)
  }
}
