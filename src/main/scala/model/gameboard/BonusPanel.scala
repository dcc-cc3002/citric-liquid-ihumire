package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/**
 * The `BonusPanel` class represents a panel in the game.
 *
 * This class provides a specific method to give a specific value of stars to a character on the panel.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */
class BonusPanel extends AbstractPanel {
  /**
   * Apply the panel's effect, including rolling a dice and giving stars to a player character.
   *
   * @param player The player character on which the panel's effect will be applied.
   */
  override def apply(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    val toGive: Int = math.min(roll * player.normaToNumber(), roll * 3)
    player.increaseStars(toGive)
  }
}
