package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer


class HomePanelTest extends FunSuite {
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _
  private var player3: PlayerCharacter = _
  private var neutral: NeutralPanel = _
  private var home: HomePanel = _
  private var bonus: BonusPanel = _
  private var drop: DropPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 10, 10, 5, 5, 0, 2, 50, 5, 1)
    player2 = new PlayerCharacter("Kira", 7, 6, 9, 1, 6, 1, 9, 0, 1)
    player3 = new PlayerCharacter("Lunita", 9, 3, 4, 3, 2, 3, 20, 5, 2)
    neutral = new NeutralPanel
    home = new HomePanel
    bonus = new BonusPanel
    drop = new DropPanel
  }

  test("Add character to home panel") {
    val expectedCharacter: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1)
    assertNotEquals(home.characters, expectedCharacter)
    home.addCharacter(player1)
    assertEquals(home.characters, expectedCharacter)
  }

  test("Remove character from a home panel") {
    home.addCharacter(player1)
    home.addCharacter(player2)
    val expectedCharacter2: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player2)
    val expectedCharacters: ArrayBuffer[PlayerCharacter] = ArrayBuffer(player1, player2)
    assertNotEquals(home.characters, expectedCharacter2)
    assertEquals(home.characters, expectedCharacters)
    home.removeCharacter(player1)
    assertEquals(home.characters, expectedCharacter2)
    assertNotEquals(home.characters, expectedCharacters)
  }

  test("Heal a character in a home panel with maxHp") {
    val expectedHpP1: Int = player1.currHp + 1
    home.healCharacter(player1)
    assertNotEquals(player1.currHp, expectedHpP1)
  }

  test("Heal a character in a home panel with not maxHp") {
    val expectedHpP2: Int = player2.currHp + 1
    home.healCharacter(player2)
    assertEquals(player2.currHp, expectedHpP2)
  }

  test("Do norma check to a character in a home panel, ending with a increase of norma") {
    // other test proving stars road
    val expectedNormaP1: Int = player1.currNorma + 1
    home.normaCheck(player1)
    assertEquals(player1.currNorma, expectedNormaP1)
  }

  test("Do norma check to a character in a home panel, ending with a stay of norma"){
    // one test proving the norma 1
    val expectedNormaP2: Int = player2.currNorma + 1
    home.normaCheck(player2)
    assertNotEquals(player2.currNorma, expectedNormaP2)

    // other test proving victories road
    val expectedNormaP3: Int = player3.currNorma + 1
    home.normaCheck(player3)
    assertNotEquals(player3.currNorma, expectedNormaP3)
  }

  test("Add a panel to nextPanels in home panel, having at 3 max") {
    val expectedOnePanel: ArrayBuffer[Panel] = ArrayBuffer(neutral)
    val expectedTwoPanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home)
    val expectedThreePanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home, bonus)
    home.addPanel(neutral)
    assertEquals(home.nextPanels, expectedOnePanel)
    home.addPanel(home)
    assertEquals(home.nextPanels, expectedTwoPanels)
    home.addPanel(bonus)
    assertEquals(home.nextPanels, expectedThreePanels)
    /* Extra addition do nothing */
    home.addPanel(drop)
    assertEquals(home.nextPanels, expectedThreePanels)
  }

  test("Remove a panel to nextPanels in home panel") {
    home.addPanel(neutral)
    home.addPanel(home)
    home.addPanel(bonus)
    val expectedNoPanel: ArrayBuffer[Panel] = ArrayBuffer()
    val expectedOnePanel: ArrayBuffer[Panel] = ArrayBuffer(neutral)
    val expectedTwoPanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home)
    val expectedThreePanels: ArrayBuffer[Panel] = ArrayBuffer(neutral, home, bonus)
    assertEquals(home.nextPanels, expectedThreePanels)
    home.removePanel(bonus)
    assertEquals(home.nextPanels, expectedTwoPanels)
    home.removePanel(home)
    assertEquals(home.nextPanels, expectedOnePanel)
    home.removePanel(neutral)
    assertEquals(home.nextPanels, expectedNoPanel)
    /* Extra remove do nothing */
    home.removePanel(neutral)
    assertEquals(home.nextPanels, expectedNoPanel)
  }
}