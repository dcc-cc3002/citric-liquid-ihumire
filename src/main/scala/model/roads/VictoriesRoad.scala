package cl.uchile.dcc.citric
package model.roads

import model.norm.Norma
import model.units.PlayerCharacter

/**
 * The `VictoriesRoad` class represents a type of road in the game, known as "Victories Road."
 *
 * "Victories Road" is a road that allows players to progress based on their accumulated victories. It is one of the road types
 * that characters can use in the board game.
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class VictoriesRoad extends Road {
  /**
   * Clears the current road for a character and sets it to a new instance of "Victories Road."
   *
   * @param road The road to be cleared, which will be replaced with a new instance of "Victories Road."
   * @return The updated road with "Victories Road."
   */
  def clearRoad(road: Road): Road = road.makeRoad()

  /**
   * Creates a new instance of "Victories Road."
   *
   * @return A new instance of "Victories Road" for the character to travel on.
   */
  def makeRoad(): Road = new VictoriesRoad

  /**
   * Adjusts the character's road based on their Norma requirements and progress, focusing on victories.
   *
   * @param norm   The Norma representing the character's current Norma level.
   * @param player The PlayerCharacter whose road is to be adjusted.
   * @return The updated Norma reflecting any changes in the character's road based on victories.
   */
  def myRoad(norm: Norma, player: PlayerCharacter): Norma = norm.checkVictories(player)
}

