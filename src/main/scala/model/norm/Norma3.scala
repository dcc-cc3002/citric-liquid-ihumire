package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

/**
 * The `Norma3` class represents a specific Norma level for a character in the game.
 * This Norma level defines advanced character status and requirements to achieve an even higher Norma level, Norma4.
 * Players need to fulfill certain criteria related to stars and victories to progress to Norma4.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class Norma3 extends Norma {
  /**
   * Checks and updates the character's Norma level based on their current status and actions related to boosts and the selected road.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on the character's actions related to boosts and the selected road.
   */
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  /**
   * Checks and updates the character's Norma level based on their current status and actions related to stars.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on the character's actions related to stars.
   */
  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma3
    if (player.currStars >= 70) norm = new Norma4
    norm
  }

  /**
   * Checks and updates the character's Norma level based on their current status and actions related to victories.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on the character's actions related to victories.
   */
  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma3
    if (player.currVictories >= 6) norm = new Norma4
    norm
  }

  /**
   * Checks and updates the character's Norma level based on a comprehensive evaluation of their current status.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on a comprehensive assessment of the character's status.
   */
  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma3
    if (player.currStars >= 70) norm = new Norma4
    else if (player.currVictories >= 6) norm = new Norma4
    norm
  }

  /**
   * Returns the numeric value representing the character's current Norma level, which is 3 for Norma3.
   *
   * @return The numeric value of the character's Norma level (3 for Norma3).
   */
  def toNumber(): Int = 3
}

