package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
/** The `DropPanel` class represents a panel in the game.
 *
 * This class provides a list of characters who are into this panel and the panels next to them.
 * Also, this class incorporates methods to modify that list of characters, adding or removing characters depend of the
 * moment in the game.
 * At this case, this class summon other specific method dropping a specific value of stars from a character in the panel.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */
class DropPanel extends AbstractPanel {

  /** Drop stars from a character into the list of characters currently on this panel.
   *
   * This might be invoked once time when a player moves into this panel.
   * Then, the player will roll a dice for calculate the number of stars to drop.
   *
   * @param player The player character to remove from this panel.
   * @param roll The number who depends the numbers of stars to drop.
   */

  def dropStars(player: PlayerCharacter, roll: Int): Unit = {
    val toDrop: Int = roll * player.currNorma
    player.decreaseStars(toDrop)
  }
}
