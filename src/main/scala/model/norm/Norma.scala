package cl.uchile.dcc.citric
package model.norm

import cl.uchile.dcc.citric.model.roads.{AllRoads, Road, StarsRoad, VictoriesRoad}
import cl.uchile.dcc.citric.model.units.PlayerCharacter
/**
 * The `Norma` trait represents a character's Norma level and defines methods to check and manipulate it.
 *
 * Norma is a character's personal victory condition in the game, and different actions can help them progress toward it.
 * Norma can be related to various factors, such as boosts, stars, victories, or a combination of these.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 * */
trait Norma {
  /**
   * Checks and updates the character's Norma level based on their current status and actions related to boosts.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on the character's actions related to boosts.
   */
  def checkBoost(player: PlayerCharacter): Norma

  /**
   * Checks and updates the character's Norma level based on their current status and actions related to stars.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on the character's actions related to stars.
   */
  def checkStars(player: PlayerCharacter): Norma

  /**
   * Checks and updates the character's Norma level based on their current status and actions related to victories.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on the character's actions related to victories.
   */
  def checkVictories(player: PlayerCharacter): Norma

  /**
   * Checks and updates the character's Norma level based on their current status and a comprehensive evaluation.
   *
   * @param player The PlayerCharacter for whom to check and update the Norma level.
   * @return The updated Norma level based on a comprehensive assessment of the character's status.
   */
  def checkAll(player: PlayerCharacter): Norma

  /**
   * Returns the numeric value representing the character's current Norma level.
   *
   * @return The numeric value of the character's Norma level.
   */
  def toNumber(): Int
}

