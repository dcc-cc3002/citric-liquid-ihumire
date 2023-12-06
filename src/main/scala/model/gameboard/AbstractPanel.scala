package cl.uchile.dcc.citric
package model.gameboard

import cl.uchile.dcc.citric.model.units.PlayerCharacter
import scala.collection.mutable.ArrayBuffer
/** Represents a basic structure for every single cell on a board.
 * This abstract class provides a list of characters who are into this panel and the panels next to them.
 * Also, this abstract class incorporates methods to modify that list of characters, adding or removing characters depend of the
 * moment in the game.
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
abstract class AbstractPanel extends Panel {
  /**
   * Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   */
  private val _characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /**
   * Get a copy of the array of characters currently on this panel.
   *
   * @return A copy of the list of characters on this panel.
   */
  def characters: ArrayBuffer[PlayerCharacter] = _characters.clone()

  /**
   * An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, and this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return A copy of the list of Panel instances that are adjacent or connected to this panel.
   */
  private val _nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  /**
   * Get a copy of the array of panels that are directly connected to this one.
   *
   * @return A copy of the list of adjacent or connected panels to this panel.
   */
  def nextPanels: ArrayBuffer[Panel] = _nextPanels.clone()

  /**
   * Adds a character to the list of characters currently on this panel.
   *
   * This might be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  def addCharacter(player: PlayerCharacter): Unit = {
    _characters.addOne(player)
  }

  /**
   * Removes a character from the list of characters currently on this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */

  def removeCharacter(player: PlayerCharacter): Unit = {
    val index: Int = characters.indexOf(player)
    _characters.remove(index)
  }

  /**
   * Adds a panel to the list of nextPanels next to this panel.
   *
   * This might be invoked when a player needs to move to another panel on their turn.
   * Only works for a maximum of 3 nextPanels.
   *
   * @param panel The panel to add to this panel's nextPanels.
   */
  def addPanel(panel: Panel): Unit = {
    if (nextPanels.length < 3){
      _nextPanels.addOne(panel)
    }
  }
  /**
   * Removes a panel from the list of nextPanels next to this panel.
   *
   * This might be invoked when a player advances to the next panel and has another nextPanels.
   * Only works for existing panels in nextPanels.
   *
   * @param panel The panel to remove from this panel's nextPanels.
   */
  def removePanel(panel: Panel): Unit = {
    if (_nextPanels.nonEmpty){
      val index: Int = _nextPanels.indexOf(panel)
      _nextPanels.remove(index)
    }
  }

  /**
   * Apply the panel's effect to a player character.
   *
   * @param player The player character on which the panel's effect will be applied.
   */
  def apply(player: PlayerCharacter): Unit = {}
}
