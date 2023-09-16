package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** The `BonusPanel` class represents a panel in the game.
 *
 * This class provides a list of characters who are into this panel and the panels next to them.
 * Also, this class incorporates methods to modify that list of characters, adding or removing characters depend of the
 * moment in the game.
 * At this case, this class summon other specific method giving a specific value of stars to a character in the panel.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class BonusPanel extends Panel {
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

  /** Give stars to a character from the list of characters currently on this panel.
   *
   * This might be invoked once time when a player moves into this panel.
   * Then, the player will roll a dice for calculate the number of stars to give.
   *
   * @param player The player character to remove from this panel.
   * @param roll The number who depends the numbers of stars to give.
   */

  def giveStars(player: PlayerCharacter, roll :Int): Unit = {
    val toGive: Int = math.min(roll * player.currNorma, roll * 3)
    player.increaseStars(toGive)
  }
}
