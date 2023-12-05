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
   * Apply the panel's effect, including rolling a dice and dropping stars from a player character.
   *
   * @param player The player character on which the panel's effect will be applied.
   */
  override def apply(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    val toDrop: Int = roll * player.normaToNumber()
    player.decreaseStars(toDrop)
  }
}
