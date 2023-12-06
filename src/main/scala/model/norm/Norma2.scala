package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

/**
 * Represents the second norma in the game, known as Norma2.
 *
 * This norma checks for conditions related to stars and victories, advancing to Norma3
 * if the player meets the specified criteria.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class Norma2 extends Norma {
  /**
   * Checks whether the player meets the conditions for the boost norma.
   *
   * @param player The player character for which the check is performed.
   * @return Norma2, advancing to Norma3 if conditions are met.
   */
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  /**
   * Checks whether the player meets the conditions for the stars norma.
   *
   * @param player The player character for which the check is performed.
   * @return Norma3 if the player's stars are greater than or equal to 30, otherwise Norma2.
   */
  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma2
    if (player.currStars >= 30) norm = new Norma3
    norm
  }

  /**
   * Checks whether the player meets the conditions for the victories norma.
   *
   * @param player The player character for which the check is performed.
   * @return Norma3 if the player's victories are greater than or equal to 3, otherwise Norma2.
   */
  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma2
    if (player.currVictories >= 3) norm = new Norma3
    norm
  }

  /**
   * Checks all conditions for norma progression.
   *
   * @param player The player character for which the check is performed.
   * @return Norma3 if either stars or victories conditions are met, otherwise Norma2.
   */
  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma2
    if (player.currStars >= 30 || player.currVictories >= 3) norm = new Norma3
    norm
  }

  /**
   * Returns the numeric representation of this norma.
   *
   * @return The number associated with this norma (2).
   */
  def toNumber(): Int = 2
}

