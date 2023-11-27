package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.norm.Norma

import scala.collection.mutable.ArrayBuffer

/**
 * The `HomePanel` class represents a panel in the game.
 *
 * This class provides specific methods such as healing a specific player within the list of characters and
 * performing a NormaCheck.
 *
 * @param owner The owner of this home panel, represented by a PlayerCharacter.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class HomePanel(val owner: PlayerCharacter) extends AbstractPanel {
  /**
   * Heals a character from the list of characters currently on this panel.
   *
   * This method might be invoked when a player moves into this panel.
   *
   * @param player The player character to heal on this panel.
   */
  def healCharacter(player: PlayerCharacter): Unit = {
    player.increaseHp(1)
  }

  /**
   * Performs a NormaCheck for a character from the list of characters currently on this panel.
   *
   * A NormaCheck invokes the NormaClear method of the character to check.
   *
   * @param player The player character to perform a NormaCheck on.
   */
  def normaCheck(player: PlayerCharacter): Unit = {
    player.normaClear()
  }
  /**
   * Apply the panel's effects, including performing a NormaCheck and healing a player character.
   *
   * @param player The player character on which the panel's effects will be applied.
   */
  override def apply(player: PlayerCharacter): Unit = {
    normaCheck(player)
    healCharacter(player)
  }
}
