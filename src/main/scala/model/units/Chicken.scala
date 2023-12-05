package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/**
 * The `Chicken` class represents a character in the game, known as a Chicken.
 *
 * Chicken is a character that can participate in the game. It has a maximum amount of Hit Points (maxHp), an attack power (attack),
 * defense (defense) to protect itself against attacks, and evasion (evasion) to dodge attacks. Chicken can also increase or decrease
 * its number of stars and health points, just like any other character.
 *
 * @param name                 The name of the Chicken character.
 * @param maxHp                The maximum Hit Points of the Chicken character.
 * @param attack               The attack power of the Chicken character.
 * @param defense              The defense of the Chicken character.
 * @param evasion              The evasion ability of the Chicken character.
 * @param randomNumberGenerator The random number generator for rolling dice.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class Chicken(name: String, maxHp: Int, attack: Int, defense: Int, evasion: Int, randomNumberGenerator: Random) extends AbstractCharacter(name, maxHp, attack, defense, evasion, randomNumberGenerator) {

  /**
   * Creates a default Chicken character with predefined attributes.
   */
  def this() = {
    this("Chicken", 3, -1, -1, 1, new Random())
    this.increaseStars(3)
  }

  /**
   * Handles the situation when Chicken character loses stars against another character.
   *
   * @param character The character to win stars from Chicken.
   */
  def loseStarsAgainst(character: Character): Unit = character.winStarsVsChicken(this)

  /**
   * Handles the situation when Chicken character loses a battle against another character.
   *
   * @param character The character to win a victory against Chicken.
   */
  def loseAgainst(character: Character): Unit = character.winVsChicken(this)
  def responseVs(character: Character, atk: Int): Unit = {
    val roll: Int = rollDice()
    val dmg: Int = defendCharacter(atk,roll)
    decreaseHp(dmg)
    transferStarsTo(character)
    giveVicTo(character)
  }
}

