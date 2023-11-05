package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.norm.Norma

import scala.collection.mutable.ArrayBuffer

/** The `HomePanel` class represents a panel in the game.
 *
 * This class summon specifics methods like heal a specific player into the list of characters and
 * do a normaCheck.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class HomePanel(val owner: PlayerCharacter) extends AbstractPanel {

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
   * A normaCheck invoke normaClear of the character to check.
   *
   * @param player The player character to normaCheck.
   */
  def normaCheck(player: PlayerCharacter): Unit = {
    player.normaClear()
  }

  override def apply(player: PlayerCharacter): Unit = {
    normaCheck(player)
    healCharacter(player)
  }
}
