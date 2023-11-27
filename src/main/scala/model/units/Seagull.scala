package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/**
 * The `Seagull` class represents a character in the game, known as a Seagull.
 *
 * Seagull is a character that can participate in the game. It has a maximum amount of Hit Points (maxHp), an attack power (attack),
 * defense (defense) to protect itself against attacks, and evasion (evasion) to dodge attacks. Seagull can also increase or decrease
 * its number of stars and health points, just like any other character.
 *
 * @param name                 The name of the Seagull character.
 * @param maxHp                The maximum Hit Points of the Seagull character.
 * @param attack               The attack power of the Seagull character.
 * @param defense              The defense of the Seagull character.
 * @param evasion              The evasion ability of the Seagull character.
 * @param randomNumberGenerator The random number generator for rolling dice.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class Seagull(name: String, maxHp: Int, attack: Int, defense: Int, evasion: Int, randomNumberGenerator: Random) extends AbstractCharacter(name, maxHp, attack, defense, evasion, randomNumberGenerator) {

  /**
   * Creates a default Seagull character with predefined attributes.
   */
  def this() = {
    this("Seagull", 3, 1, -1, -1, new Random())
    this.increaseStars(2)
  }

  /**
   * Handles the situation when Seagull character loses stars against another character.
   *
   * @param character The character to win stars from Seagull.
   */
  def loseStarsAgainst(character: Character): Unit = character.winStarsVsSeagull(this)

  /**
   * Handles the situation when Seagull character loses a battle against another character.
   *
   * @param character The character to win a victory against Seagull.
   */
  def loseAgainst(character: Character): Unit = character.winVsSeagull(this)
}

