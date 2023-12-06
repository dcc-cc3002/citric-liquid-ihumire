package cl.uchile.dcc.citric
package model.roads

import model.norm.Norma
import model.units.PlayerCharacter

/**
 * The `StarsRoad` class represents a type of road in the game, known as "Stars Road."
 *
 * "Stars Road" is a road that allows players to progress based on their accumulated stars. It is one of the road types
 * that characters can use in the board game.
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class StarsRoad extends Road {
  /**
   * Clears the current road for a character and sets it to a new instance of "Stars Road."
   *
   * @param road The road to be cleared, which will be replaced with a new instance of "Stars Road."
   * @return The updated road with "Stars Road."
   */
  def clearRoad(road: Road): Road = road.makeRoad()

  /**
   * Creates a new instance of "Stars Road."
   *
   * @return A new instance of "Stars Road" for the character to travel on.
   */
  def makeRoad(): Road = new StarsRoad

  /**
   * Adjusts the character's road based on their Norma requirements and progress, focusing on stars.
   *
   * @param norm   The Norma representing the character's current Norma level.
   * @param player The PlayerCharacter whose road is to be adjusted.
   * @return The updated Norma reflecting any changes in the character's road based on stars.
   */
  def myRoad(norm: Norma, player: PlayerCharacter): Norma = norm.checkStars(player)
}
