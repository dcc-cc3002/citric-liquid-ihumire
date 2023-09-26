package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** The `BonusPanel` class represents a panel in the game.
 *
 * This class summon a specific method giving a specific value of stars to a character in the panel.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class BonusPanel extends AbstractPanel {

  /** Give stars to a character from the list of characters currently on this panel.
   *
   * This might be invoked once time when a player moves into this panel.
   * Then, the player will roll a dice for calculate the number of stars to give.
   *
   * @param player The player character to remove from this panel.
   * @param roll The number who depends the numbers of stars to give.
   */

  def giveStars(player: PlayerCharacter, roll: Int): Unit = {
    val toGive: Int = math.min(roll * player.currNorma, roll * 3)
    player.increaseStars(toGive)
  }
}
