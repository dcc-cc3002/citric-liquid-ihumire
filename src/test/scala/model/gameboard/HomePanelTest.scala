package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.norm.{Norma, Norma1, Norma2}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer


class HomePanelTest extends FunSuite {
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _
  private var neutral: NeutralPanel = _
  private var home: HomePanel = _
  private var home2: HomePanel = _
  private var bonus: BonusPanel = _
  private var drop: DropPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new PlayerCharacter("Molly", 5, 1, 1, 0)
    player2 = new PlayerCharacter("Kira", 5, 1, -1, 1)
    neutral = new NeutralPanel
    home = new HomePanel(player1)
    home2 = new HomePanel(player2)
    bonus = new BonusPanel
    drop = new DropPanel
  }

  test("HomePanel have an owner corretly setter"){
    assertEquals(home.owner, player1)
    assertEquals(home2.owner, player2)
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
    val expectedHp: Int = player1.currHp + 1
    home.healCharacter(player1)
    assertNotEquals(player1.currHp, expectedHp)
  }

  test("Heal a character in a home panel with not maxHp") {
    player1.decreaseHp(2)
    val expectedHp: Int = player1.currHp + 1
    home.healCharacter(player1)
    assertEquals(player1.currHp, expectedHp)
  }

  test("Do norma check to a character in a home panel, ending with a increase of norma") {
    player1.increaseStars(10)
    home.normaCheck(player1)
    assert(player1.currNorma.isInstanceOf[Norma2])
  }

  test("Do norma check to a character in a home panel, ending with a stay of norma"){
    home.normaCheck(player1)
    assert(player1.currNorma.isInstanceOf[Norma1])
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

  test("A home panel should be applied his action to a character") {
    player1.decreaseHp(2)
    player1.increaseStars(10)
    val notExpectedHp: Int = player1.currHp
    home.apply(player1)
    assert(notExpectedHp < player1.currHp)
    assert(player1.currNorma.isInstanceOf[Norma2])
  }
}