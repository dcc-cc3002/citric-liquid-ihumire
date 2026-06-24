package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

/**
 * Represents the sixth norma in the game, known as Norma6.
 *
 * This norma does not have specific conditions for stars or victories, and it
 * always returns itself for all checks.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class Norma6 extends Norma {
  /**
   * Checks whether the player meets the conditions for the boost norma.
   *
   * @param player The player character for which the check is performed.
   * @return Norma6, as this norma has no specific conditions.
   */
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  /**
   * Checks whether the player meets the conditions for the stars norma.
   *
   * @param player The player character for which the check is performed.
   * @return Norma6, as this norma has no specific conditions.
   */
  def checkStars(player: PlayerCharacter): Norma = this

  /**
   * Checks whether the player meets the conditions for the victories norma.
   *
   * @param player The player character for which the check is performed.
   * @return Norma6, as this norma has no specific conditions.
   */
  def checkVictories(player: PlayerCharacter): Norma = this

  /**
   * Checks all conditions for norma progression.
   *
   * @param player The player character for which the check is performed.
   * @return Norma6, as this norma has no specific conditions.
   */
  def checkAll(player: PlayerCharacter): Norma = this

  /**
   * Returns the numeric representation of this norma.
   *
   * @return The number associated with this norma.
   */
  override def toNumber(): Int = 6
}
