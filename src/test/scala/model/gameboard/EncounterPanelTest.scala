package cl.uchile.dcc.citric
package model.gameboard

import model.units.{PlayerCharacter, WildUnitCharacter}

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class EncounterPanelTest extends FunSuite {/*
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _
  private var neutral: NeutralPanel = _
  private var home: HomePanel = _
  private var bonus: BonusPanel = _
  private var drop: DropPanel = _
  private var encounter: EncounterPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10, 5, 5, 0, 2, 50, 5, 1)
    player2 = new PlayerCharacter("Kira", 7, 6, 9, 1, 6, 1, 20, 2, 0)
    neutral = new NeutralPanel
    home = new HomePanel
    bonus = new BonusPanel
    drop = new DropPanel
    encounter = new EncounterPanel
  }

  test("Add character to encounter panel") {
    val expectedNothing: ArrayBuffer[PlayerCharacter] = ArrayBuffer()
    val expectedCharacter: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertEquals(encounter.characters, expectedNothing)
    assertNotEquals(encounter.characters, expectedCharacter)
    encounter.addCharacter(player1)
    assertNotEquals(encounter.characters, expectedNothing)
    assertEquals(encounter.characters, expectedCharacter)
  }

  test("Remove character from an encounter panel") {
    encounter.addCharacter(player1)
    encounter.addCharacter(player2)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1, player2)
    assertNotEquals(encounter.characters, expectedCharacter2)
    assertEquals(encounter.characters, expectedCharacters)
    encounter.removeCharacter(player1)
    assertEquals(encounter.characters, expectedCharacter2)
    assertNotEquals(encounter.characters, expectedCharacters)
  }

  test("Add a random wild unit to encounter panel only if is empty") {
    val expectedChicken: ArrayBuffer[WildUnitCharacter] = ArrayBuffer(encounter.enemyChicken)
    val expectedRoboBall: ArrayBuffer[WildUnitCharacter] = ArrayBuffer(encounter.enemyRoboBall)
    val expectedSeagull: ArrayBuffer[WildUnitCharacter] = ArrayBuffer(encounter.enemySeagull)
    encounter.addRandomWildUnit()
    assert(encounter.wildUnitInPanel == expectedChicken || encounter.wildUnitInPanel == expectedRoboBall
      || encounter.wildUnitInPanel == expectedSeagull)
    encounter.addRandomWildUnit()
    assert(encounter.wildUnitInPanel == expectedChicken || encounter.wildUnitInPanel == expectedRoboBall
      || encounter.wildUnitInPanel == expectedSeagull)

  }

  test("Remove a wild unit from an encounter panel only if is death") {
    encounter.addRandomWildUnit()
    val expectedNothing: ArrayBuffer[WildUnitCharacter] = ArrayBuffer()
    encounter.removeWildUnit()
    assertNotEquals(encounter.wildUnitInPanel, expectedNothing)
    encounter.wildUnitInPanel(0).decreaseHp(3)
    encounter.removeWildUnit()
    assertEquals(encounter.wildUnitInPanel, expectedNothing)
  }

  test("Add a panel to nextPanels in drop panel, having at 3 max") {
    val expectedOnePanel: ArrayBuffer[Panel] = ArrayBuffer(neutral)
    val expectedTwoPanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home)
    val expectedThreePanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home, bonus)
    drop.addPanel(neutral)
    assertEquals(drop.nextPanels, expectedOnePanel)
    drop.addPanel(home)
    assertEquals(drop.nextPanels, expectedTwoPanels)
    drop.addPanel(bonus)
    assertEquals(drop.nextPanels, expectedThreePanels)
    /* Extra addition do nothing */
    drop.addPanel(drop)
    assertEquals(drop.nextPanels, expectedThreePanels)
  }

  test("Remove a panel to nextPanels in drop panel") {
    drop.addPanel(neutral)
    drop.addPanel(home)
    drop.addPanel(bonus)
    val expectedNoPanel: ArrayBuffer[Panel] = ArrayBuffer()
    val expectedOnePanel: ArrayBuffer[Panel] = ArrayBuffer(neutral)
    val expectedTwoPanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home)
    val expectedThreePanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home, bonus)
    assertEquals(drop.nextPanels, expectedThreePanels)
    drop.removePanel(bonus)
    assertEquals(drop.nextPanels, expectedTwoPanels)
    drop.removePanel(home)
    assertEquals(drop.nextPanels, expectedOnePanel)
    drop.removePanel(neutral)
    assertEquals(drop.nextPanels, expectedNoPanel)
    /* Extra remove do nothing */
    drop.removePanel(neutral)
    assertEquals(drop.nextPanels, expectedNoPanel)
  }*/
}
