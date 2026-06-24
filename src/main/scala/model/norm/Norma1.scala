package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

/**
 * The `Norma1` class represents a specific Norma level for a character in the game.
 * This Norma level defines the initial character status and requirements to achieve a higher Norma level.
 * Players need to fulfill certain criteria related to stars and victories to progress to Norma2.

 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class Norma1 extends Norma {
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
    var norm: Norma = new Norma1
    if (player.currStars >= 10) norm = new Norma2
    norm
  }

  /**
   * Checks and updates the character's Norma level based on their current status and actions related to victories.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on the character's actions related to victories.
   */
  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma1
    if (player.currVictories >= 1) norm = new Norma2
    norm
  }

  /**
   * Checks and updates the character's Norma level based on a comprehensive evaluation of their current status.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on a comprehensive assessment of the character's status.
   */
  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma1
    if (player.currStars >= 10) norm = new Norma2
    else if (player.currVictories >= 1) norm = new Norma2
    norm
  }

  /**
   * Returns the numeric value representing the character's current Norma level, which is 1 for Norma1.
   *
   * @return The numeric value of the character's Norma level (1 for Norma1).
   */
  def toNumber(): Int = 1
}

