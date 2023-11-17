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
   * Gives stars to a character from the list of characters currently on this panel.
   *
   * This method might be invoked when a player moves into this panel. The player will roll a dice to calculate
   * the number of stars to give.
   *
   * @param player The player character to receive stars on this panel.
   * @param roll   The number that determines the number of stars to give.
   */
  def giveStars(player: PlayerCharacter, roll: Int): Unit = {
    val toGive: Int = math.min(roll * player.normaToNumber(), roll * 3)
    player.increaseStars(toGive)
  }
  /**
   * Apply the panel's effect, including rolling a dice and giving stars to a player character.
   *
   * @param player The player character on which the panel's effect will be applied.
   */
  override def apply(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    giveStars(player, roll)
  }
}
