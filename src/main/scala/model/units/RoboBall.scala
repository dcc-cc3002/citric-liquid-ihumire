package cl.uchile.dcc.citric
package model.units

import scala.util.Random
/**
 * The 'RoboBall' class represents a character in the game, known as a RoboBall.
 *
 * RoboBall is a character that can participate in the game. It has a maximum amount of Hit Points (maxHp), an attack power (attack),
 * defense (defense) to protect itself against attacks, and evasion (evasion) to dodge attacks. RoboBall can also increase or decrease
 * its number of stars and health points, just like any other character.
 *
 * @param name                 The name of the RoboBall character.
 * @param maxHp                The maximum Hit Points of the RoboBall character.
 * @param attack               The attack power of the RoboBall character.
 * @param defense              The defense of the RoboBall character.
 * @param evasion              The evasion ability of the RoboBall character.
 * @param randomNumberGenerator The random number generator for rolling dice.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class RoboBall(name: String,
               maxHp: Int,
               attack: Int,
               defense: Int,
               evasion: Int,
               randomNumberGenerator: Random) extends AbstractCharacter (name, maxHp, attack, defense, evasion, randomNumberGenerator){
  /**
   * Creates a default RoboBall character with predefined attributes.
   */
  def this() = {
    this("RoboBall", 3, -1, 1, -1, new Random())
    this.increaseStars(2)
  }
  /**
   * Handles the situation when RoboBall character loses stars against another character.
   *
   * @param character The character to win stars from RoboBall.
   */
  def loseStarsAgainst(character: Character): Unit = character.winStarsVsRoboBall(this)

  /**
   * Handles the situation when RoboBall character loses a battle against another character.
   *
   * @param character The character to win a victory against RoboBall.
   */
  def loseAgainst(character: Character): Unit = character.winVsRoboBall(this)
}
