package cl.uchile.dcc.citric
package model.gameboard

import cl.uchile.dcc.citric.model.units.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/ihumire Ignacio Humire S.]]
  */
trait Panel {
  /** Adds a character to the list of characters currently on this panel.
    *
    * This might be invoked when a player moves to this panel or starts their turn on it.
    *
    * @param player The player character to add to this panel.
    */
  def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from the list of characters currently on this panel.
    *
    * This might be invoked when a player moves off this panel.
    *
    * @param player The player character to remove from this panel.
    */
  def removeCharacter(player: PlayerCharacter): Unit

  /**
   * Apply the panel's effect to a player character.
   *
   * @param player The player character on which the panel's effect will be applied.
   */
  def apply(player: PlayerCharacter): Unit
}
