package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
/**
 * The `DropPanel` class represents a panel in the game.
 *
 * This class provides a specific method to drop a specific value of stars from a character on the panel.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */
class DropPanel extends AbstractPanel {
  /**
   * Drops stars from a character in the list of characters currently on this panel.
   *
   * This method might be invoked when a player moves into this panel. The player will roll a dice to calculate
   * the number of stars to drop.
   *
   * @param player The player character to have stars dropped from on this panel.
   * @param roll   The number that determines the number of stars to drop.
   */
  def dropStars(player: PlayerCharacter, roll: Int): Unit = {
    val toDrop: Int = roll * player.normaToNumber()
    player.decreaseStars(toDrop)
  }
  /**
   * Apply the panel's effect, including rolling a dice and dropping stars from a player character.
   *
   * @param player The player character on which the panel's effect will be applied.
   */
  override def apply(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    dropStars(player, roll)
  }
}
