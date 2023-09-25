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

class HomePanel extends AbstractPanel {

  /** Heals a character from the list of characters currently on this panel.
   *
   * This might be invoked once time when a player moves into this panel.
   *
   * @param player The player character to heal in this panel.
   */

  def healCharacter(player: PlayerCharacter): Unit = {
    player.increaseHp(1)
  }

  /** Do a NormaCheck to a character from the list of characters currently on this panel.
   *
   * A normaCheck checks if the character is able to advance his Norma.
   * This might be invoked once time when a player moves into this panel.
   *
   * @param player The player character to heal in this panel.
   */

  def normaCheck(player: PlayerCharacter): Unit = {
    player.normaClear()
  }
}
