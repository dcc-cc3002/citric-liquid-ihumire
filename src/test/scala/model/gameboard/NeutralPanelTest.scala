package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.norm.Norma1

import scala.collection.mutable.ArrayBuffer
import munit.FunSuite

class NeutralPanelTest extends FunSuite {
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

  test("Add a panel to nextPanels in neutral panel, having at 3 max") {
    val expectedOnePanel: ArrayBuffer[Panel] = ArrayBuffer(neutral)
    val expectedTwoPanels: ArrayBuffer[Panel] = ArrayBuffer(neutral,home)
    val expectedThreePanels: ArrayBuffer[Panel] = ArrayBuffer(neutral,home,bonus)
    neutral.addPanel(neutral)
    assertEquals(neutral.nextPanels, expectedOnePanel)
    neutral.addPanel(home)
    assertEquals(neutral.nextPanels, expectedTwoPanels)
    neutral.addPanel(bonus)
    assertEquals(neutral.nextPanels, expectedThreePanels)
    /* Extra addition do nothing */
    neutral.addPanel(drop)
    assertEquals(neutral.nextPanels, expectedThreePanels)
  }

  test("Remove a panel to nextPanels in neutral panel") {
    neutral.addPanel(neutral)
    neutral.addPanel(home)
    neutral.addPanel(bonus)
    val expectedNoPanel: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val expectedOnePanel: ArrayBuffer[Panel] = ArrayBuffer[Panel](neutral)
    val expectedTwoPanels: ArrayBuffer[Panel] = ArrayBuffer[Panel](neutral, home)
    val expectedThreePanels: ArrayBuffer[Panel] = ArrayBuffer[Panel](neutral, home, bonus)
    assertEquals(neutral.nextPanels, expectedThreePanels)
    neutral.removePanel(bonus)
    assertEquals(neutral.nextPanels, expectedTwoPanels)
    neutral.removePanel(home)
    assertEquals(neutral.nextPanels, expectedOnePanel)
    neutral.removePanel(neutral)
    assertEquals(neutral.nextPanels, expectedNoPanel)
    /* Extra remove do nothing */
    neutral.removePanel(neutral)
    assertEquals(neutral.nextPanels, expectedNoPanel)
  }

  test("NeutralPanel has no effect"){
    val eHp: Int = player1.currHp
    val eStars: Int = player1.currStars
    val eVictories: Int = player1.currVictories
    val eRoad: Int = player1.currRoad
    neutral.apply(player1)
    assertEquals(player1.currHp, eHp)
    assertEquals(player1.currStars, eStars)
    assertEquals(player1.currVictories, eVictories)
    assertEquals(player1.currRoad, eRoad)
    assert(player1.currNorma.isInstanceOf[Norma1])
  }

}
