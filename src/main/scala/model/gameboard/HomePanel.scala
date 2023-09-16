package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** The `HomePanel` class represents a panel in the game.
 *
 * This class provides a list of characters who are into this panel and the panels next to them.
 * Also, this class incorporates methods to modify that list of characters, adding or removing characters depend of the
 * moment in the game.
 * At this case, this class summon other specific methods like heal a specific player into the list of characters and
 * do a normaCheck.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class HomePanel extends Panel {
  /** Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   */
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  /** Adds a character to the list of characters currently on this panel.
   *
   * This might be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  def addCharacter(player: PlayerCharacter): Unit = {
    characters.addOne(player)
  }

  /** Removes a character from the list of characters currently on this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
  */

  def removeCharacter(player: PlayerCharacter): Unit = {
    val index: Int = characters.indexOf(player)
    characters.remove(index)
  }

  def healCharacter(player: PlayerCharacter): Unit = {
    if (player.maxHp == player.currHp) {
      player.currHp = player.maxHp
    }
    else {
      player.currHp += 1
    }
  }

  def normaCheck(player: PlayerCharacter): Unit = {

    if (player.currNorma == 1) {
      if ((player.currStars >= 10) || (player.currVictories >= 1)){
        player.advanceNorma()
      }
    }

    else if(player.currNorma == 2) {
      if ((player.currRoad == 1) && (player.currStars >= 30)) {
        player.advanceNorma()
      }
      else if ((player.currRoad == 2) && (player.currVictories >= 3)){
        player.advanceNorma()
      }
    }

    else if (player.currNorma == 3) {
      if ((player.currRoad == 1) && (player.currStars >= 70)) {
        player.advanceNorma()
      }
      else if ((player.currRoad == 2) && (player.currVictories >= 6)) {
        player.advanceNorma()
      }
    }

    else if (player.currNorma == 4) {
      if ((player.currRoad == 1) && (player.currStars >= 120)) {
        player.advanceNorma()
      }
      else if ((player.currRoad == 2) &&  (player.currVictories >= 10)) {
        player.advanceNorma()
      }
    }

    else if (player.currNorma == 5) {
      if ((player.currRoad == 1) && (player.currStars >= 200)) {
        player.advanceNorma()
      }
      else if ((player.currRoad == 2) && (player.currVictories >= 14)) {
        player.advanceNorma()
      }
    }
  }

}
