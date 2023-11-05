package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/** Represents every unit in the game, known as a Character.
 *
 * A unit is defined as the entity that will participate in the game, either as
 * a character, controllable by the user, or as a Wild Unit, not controllable by the user.
 * All units have a maximum amount of Hit Points (maxHp) and a number of current Hit Points (currHp).
 * They will have a certain amount of damage points (ATK), defense (DEF) to protect
 * themselves against attacks and evasion (EVA) to try to dodge an attack completely.
 * Also, the characters have to define obligatory the elemental methods of:
 * - Roll a dice
 * - Increase or decrease his amount of stars.
 * - Increase or decrease the health points in the specific moment of the game.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
trait Character {
  val name: String
  val maxHp: Int
  val attack: Int
  val defense: Int
  val evasion: Int
  val randomNumberGenerator: Random

  /**
   * Rolls a dice
   */
  def rollDice(): Int

  /**
   * A character increase his amount of stars by a specific value.
   *
   * @param value The number of stars given to the character bigger than 0.
   */
  def increaseStars(value: Int): Unit
  /**
   * A character decrease his amount of stars by a specific value.
   *
   * @param value The number of stars drop it by the character bigger than 0.
   */
  def decreaseStars(value: Int): Unit
  /**
   * A character decrease his health points by a specific value.
   *
   * @param value The number of health points, bigger than 0, steal to the character at least 0.
   */
  def decreaseHp(value: Int): Unit
  /**
   * A character increase his health points by a specific value.
   *
   * @param value The number of health points, bigger than 0, given to the character less than maxHp.
   */
  def increaseHp(value: Int): Unit

  def attackCharacter(value: Int): Int

  def defendCharacter(atkDamage: Int, value: Int): Int

  def avoidCharacter(atkDamage: Int, value: Int): Int

  def transferStars(character: Character): Int/*
  def transferPlayer(player: PlayerCharacter): Int
  def transferWildUnit(wild: WildUnitCharacter): Int*/

}
