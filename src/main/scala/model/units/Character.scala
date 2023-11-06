package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/**
 * Represents every unit in the game, known as a Character.
 *
 * A unit is defined as the entity that will participate in the game, either as
 * a character, controllable by the user, or as a Wild Unit, not controllable by the user.
 * All units have a maximum amount of Hit Points (maxHp) and a number of current Hit Points (currHp).
 * They will have a certain amount of damage points (ATK), defense (DEF) to protect
 * themselves against attacks and evasion (EVA) to try to dodge an attack completely.
 * Also, the characters must implement the following methods:
 *
 * - rollDice(): Int - Rolls a dice.
 * - increaseStars(value: Int): Unit - Increases the character's amount of stars by a specific value.
 * - decreaseStars(value: Int): Unit - Decreases the character's amount of stars by a specific value.
 * - decreaseHp(value: Int): Unit - Decreases the character's health points by a specific value.
 * - increaseHp(value: Int): Unit - Increases the character's health points by a specific value.
 *
 * Additionally, the trait defines various methods to handle interactions between characters and specific actions in the game.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
trait Character {
  /**
   * The name of the character.
   */
  val name: String
  /**
   * The maximum amount of Hit Points (HP) the character can have.
   */
  val maxHp: Int
  /**
   * The character's attack power.
   */
  val attack: Int
  /**
   * The character's defense power.
   */
  val defense: Int
  /**
   * The character's evasion power.
   */
  val evasion: Int
  /**
   * A random number generator for various game actions.
   *
   */
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

  /**
   * Performs an attack action with a given value and returns the result.
   *
   * This method represents the character's offensive action within the game. The character initiates
   * an attack with the provided value. The method calculates the result of the attack, considering
   * factors such as the character's attack power, the value of the attack, and any defensive actions
   * taken by the target.
   *
   * @param value The value of the attack, typically a positive integer representing the strength of the attack.
   * @return An integer representing the result of the attack action, which may include damage dealt to the target.
   */
  def attackCharacter(value: Int): Int
  /**
   * Performs a defensive action against an incoming attack, considering the attack damage and value.
   *
   * When a character is subjected to an attack, this method allows the character to defend themselves.
   * The method takes into account the damage inflicted by the incoming attack (atkDamage) and the specific
   * defensive action value (value) chosen by the character to determine the outcome of the defense.
   *
   * @param atkDamage The damage inflicted by the incoming attack. Should be a positive integer representing the strength of the attack.
   * @param value The value associated with the character's defensive action.
   * @return An integer representing the result of the defense action. This value may reflect the amount of damage mitigated or other defensive effects.
   */
  def defendCharacter(atkDamage: Int, value: Int): Int
  /**
   * Attempts to avoid an incoming attack with a given damage and value, and returns the result.
   *
   * This method enables the character to make an evasion attempt to avoid or mitigate an incoming attack.
   * The method takes into account the attack's damage (atkDamage) and the specific evasion value (value) chosen
   * by the character to calculate the outcome of the evasion attempt.
   *
   * @param atkDamage The damage inflicted by the incoming attack. Should be a positive integer representing the strength of the attack.
   * @param value The value associated with the character's evasion attempt.
   * @return An integer representing the result of the evasion action, which may include the extent of damage avoided or other evasion-related effects.
   */
  def avoidCharacter(atkDamage: Int, value: Int): Int

  /**
   * Deducts stars from the character as a result of an interaction with another character.
   *
   * This method is called when the character loses stars in an interaction with a different character.
   *
   * @param character The character with whom the interaction results in losing stars.
   */
  def loseStarsAgainst(character: Character): Unit

  /**
   * Awards stars to the character as a result of a successful interaction with a player character.
   *
   * This method is invoked when the character wins stars in an interaction with a player character.
   *
   * @param player The player character with whom the interaction results in winning stars.
   */
  def winStarsVsPlayer(player: PlayerCharacter): Unit

  /**
   * Awards stars to the character as a result of a successful interaction with a Chicken.
   *
   * This method is called when the character wins stars in an interaction with a Chicken.
   *
   * @param chicken The Chicken character with whom the interaction results in winning stars.
   */
  def winStarsVsChicken(chicken: Chicken): Unit

  /**
   * Awards stars to the character as a result of a successful interaction with a RoboBall.
   *
   * This method is invoked when the character wins stars in an interaction with a RoboBall.
   *
   * @param roboBall The RoboBall character with whom the interaction results in winning stars.
   */
  def winStarsVsRoboBall(roboBall: RoboBall): Unit

  /**
   * Awards stars to the character as a result of a successful interaction with a Seagull.
   *
   * This method is called when the character wins stars in an interaction with a Seagull.
   *
   * @param seagull The Seagull character with whom the interaction results in winning stars.
   */
  def winStarsVsSeagull(seagull: Seagull): Unit

  /**
   * Handles the character losing a battle or interaction against another character.
   *
   * This method is called when the character loses a battle or interaction against another character.
   *
   * @param character The character against whom the interaction results in losing.
   */
  def loseAgainst(character: Character): Unit

  /**
   * Handles the character winning a battle or interaction against a player character.
   *
   * This method is invoked when the character wins a battle or interaction against a player character.
   *
   * @param player The player character against whom the interaction results in winning.
   */
  def winVsPlayer(player: PlayerCharacter): Unit

  /**
   * Handles the character winning a battle or interaction against a Chicken.
   *
   * This method is called when the character wins a battle or interaction against a Chicken.
   *
   * @param chicken The Chicken character against whom the interaction results in winning.
   */
  def winVsChicken(chicken: Chicken): Unit

  /**
   * Handles the character winning a battle or interaction against a RoboBall.
   *
   * This method is invoked when the character wins a battle or interaction against a RoboBall.
   *
   * @param roboBall The RoboBall character against whom the interaction results in winning.
   */
  def winVsRoboBall(roboBall: RoboBall): Unit

  /**
   * Handles the character winning a battle or interaction against a Seagull.
   *
   * This method is called when the character wins a battle or interaction against a Seagull.
   *
   * @param seagull The Seagull character against whom the interaction results in winning.
   */
  def winVsSeagull(seagull: Seagull): Unit

  /**
   * Transfers stars from the character to another character in the game.
   *
   * This method allows the character to transfer stars to another character.
   *
   * @param character The character to whom stars are transferred.
   */
  def transferStarsTo(character: Character): Unit

  /**
   * Grants a victory to another character in the game.
   *
   * This method allows the character to confer a victory to another character.
   *
   * @param character The character to whom the victory is given.
   */
  def giveVicTo(character: Character): Unit

}
