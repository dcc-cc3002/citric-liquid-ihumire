package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

/**
 * Represents the fourth norma in the game, known as Norma4.
 *
 * This norma checks conditions related to stars and victories to determine if the player
 * should progress to the next norma level, Norma5.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class Norma4 extends Norma {
  /**
   * Checks whether the player meets the conditions for the boost norma.
   *
   * @param player The player character for which the check is performed.
   * @return The next norma if conditions are met, otherwise Norma4.
   */
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  /**
   * Checks whether the player meets the conditions for the stars norma.
   *
   * @param player The player character for which the check is performed.
   * @return The next norma if conditions are met, otherwise Norma4.
   */
  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma4
    if (player.currStars >= 120) norm = new Norma5
    norm
  }

  /**
   * Checks whether the player meets the conditions for the victories norma.
   *
   * @param player The player character for which the check is performed.
   * @return The next norma if conditions are met, otherwise Norma4.
   */
  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma4
    if (player.currVictories >= 10) norm = new Norma5
    norm
  }

  /**
   * Checks all conditions for norma progression (stars and victories).
   *
   * @param player The player character for which the check is performed.
   * @return The next norma if conditions are met, otherwise Norma4.
   */
  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma4
    if (player.currStars >= 120) norm = new Norma5
    else if (player.currVictories >= 10) norm = new Norma5
    norm
  }

  /**
   * Returns the numeric representation of this norma.
   *
   * @return The number associated with this norma.
   */
  def toNumber(): Int = 4
}