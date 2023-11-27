package cl.uchile.dcc.citric
package model.roads
import model.norm.Norma
import model.units.PlayerCharacter

/**
 * The `AllRoads` class represents a type of road in the game, known as "All Roads."
 *
 * "All Roads" is a road that allows players to move freely without any specific restrictions. It is one of the road types
 * that characters can use in the board game.
 */
/**
 * The `AllRoads` class represents a type of road in the game, known as "All Roads."
 *
 * "All Roads" is a road that allows players to move freely without any specific restrictions. It is one of the road types
 * that characters can use in the board game.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class AllRoads extends Road {
  /**
   * Clears the current road for a character and sets it to a new instance of "All Roads."
   *
   * @param road The road to be cleared, which will be replaced with a new instance of "All Roads."
   * @return The updated road with "All Roads."
   */
  def clearRoad(road: Road): Road = road.makeRoad()

  /**
   * Creates a new instance of "All Roads."
   *
   * @return A new instance of "All Roads" for the character to travel on.
   */
  def makeRoad(): Road = new AllRoads

  /**
   * Adjusts the character's road based on their Norma requirements and progress.
   *
   * @param norm   The Norma representing the character's current Norma level.
   * @param player The PlayerCharacter whose road is to be adjusted.
   * @return The updated Norma reflecting any changes in the character's road.
   */
  def myRoad(norm: Norma, player: PlayerCharacter): Norma = norm.checkAll(player)
}

