package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

/**
 * Represents the fifth norma in the game, known as Norma5.
 *
 * This norma checks conditions related to stars and victories to determine if the player
 * should progress to the next norma level, Norma6. Additionally, it notifies observers when
 * Norma6 is reached.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class Norma5 extends Norma {
  /**
   * Checks whether the player meets the conditions for the boost norma.
   *
   * @param player The player character for which the check is performed.
   * @return The next norma if conditions are met, otherwise Norma5.
   */
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  /**
   * Checks whether the player meets the conditions for the stars norma.
   * Notifies observers if Norma6 is reached.
   *
   * @param player The player character for which the check is performed.
   * @return The next norma if conditions are met, otherwise Norma5.
   */
  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma5
    if (player.currStars >= 200) {
      norm = new Norma6
      player.notifyObservers("Norma six reach")
    }
    norm
  }

  /**
   * Checks whether the player meets the conditions for the victories norma.
   * Notifies observers if Norma6 is reached.
   *
   * @param player The player character for which the check is performed.
   * @return The next norma if conditions are met, otherwise Norma5.
   */
  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma5
    if (player.currVictories >= 14) {
      norm = new Norma6
      player.notifyObservers("Norma six reach")
    }
    norm
  }

  /**
   * Checks all conditions for norma progression (stars and victories).
   * Notifies observers if Norma6 is reached.
   *
   * @param player The player character for which the check is performed.
   * @return The next norma if conditions are met, otherwise Norma5.
   */
  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma5
    if (player.currStars >= 200) {
      norm = new Norma6
      player.notifyObservers("Norma six reach")
    }
    else if (player.currVictories >= 14) {
      norm = new Norma6
      player.notifyObservers("Norma six reach")
    }
    norm
  }

  /**
   * Returns the numeric representation of this norma.
   *
   * @return The number associated with this norma.
   */
  def toNumber(): Int = 5
}