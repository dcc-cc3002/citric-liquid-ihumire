package cl.uchile.dcc.citric
package model.roads

import model.units.PlayerCharacter
import model.norm.Norma

/**
 * The `Road` trait represents a road or path in the game.
 *
 * Roads are essential for character movement and gameplay in the board game. This trait defines methods
 * that allow characters to clear a road, create a road, and interact with their current road based on their Norma.
 *
 *  * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
trait Road {
  /**
   * Clears the current road for the character and sets it to a new road.
   *
   * @param road The new road to set for the character.
   * @return The updated road after clearing and setting a new one.
   */
  def clearRoad(road: Road): Road

  /**
   * Creates a new road for the character to travel on.
   *
   * @return The newly created road for the character.
   */
  def makeRoad(): Road

  /**
   * Adjusts the character's road based on their Norma requirements and progress.
   *
   * @param norm   The Norma representing the character's current Norma level.
   * @param player The PlayerCharacter whose road is to be adjusted.
   * @return The updated Norma reflecting any changes in the character's road.
   */
  def myRoad(norm: Norma, player: PlayerCharacter): Norma
}
