package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/**
 * Represents the constants and methods of any type of character in the game.
 *
 * This abstract class serves as a foundation for all character types, providing common characteristics
 * and behaviors. It includes methods for rolling a dice, managing stars, and handling health points.
 *
 * @param _name The name of the character.
 * @param _maxHp The maximum health points the character can have.
 * @param _attack The character's attack power.
 * @param _defense The character's defense power.
 * @param _evasion The character's evasion ability.
 * @param _randomNumberGenerator A random number generator for dice rolling.
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
abstract class AbstractCharacter(private val _name: String,
                                 private val _maxHp: Int,
                                 private val _attack: Int,
                                 private val _defense: Int,
                                 private val _evasion: Int,
                                 private val _randomNumberGenerator: Random) extends Character {
  /**
   * Getter name
   */
  def name: String = _name
  /**
   * Getter maxHp
   */
  def maxHp: Int = _maxHp

  /**
   * Getter attack
   */
  def attack: Int = _attack
  /**
   * Getter defense
   */
  def defense: Int = _defense
  /**
   * Getter evasion
   */
  def evasion: Int = _evasion
  /**
   * Getter randomNumberGenerator
   */
  def randomNumberGenerator: Random = _randomNumberGenerator

  private var _currHp: Int = maxHp
  /**
   * Current health points of the character.
   */
  def currHp: Int = _currHp
  /**
   * Sets the current health points of the character, ensuring it stays within the valid range.
   *
   * @param newCurrHp The new current health points to set.
   */
  def currHp_=(newCurrHp: Int): Unit = {
    if (newCurrHp < 0) {
      _currHp = 0
    }
    else if (newCurrHp > maxHp){
      _currHp = maxHp
    }
    else{
      _currHp = newCurrHp
    }
  }
  private var _currStars: Int = 0
  /**
   * Current number of stars possessed by the character.
   */
  def currStars: Int = _currStars
  /**
   * Sets the current number of stars possessed by the character, ensuring it is non-negative.
   *
   * @param newCurrStars The new current number of stars to set.
   */
  def currStars_=(newCurrStars: Int): Unit = {
    _currStars = math.max(0, newCurrStars)
  }
  /**
   * Rolls a dice and returns a value between 1 to 6.
   *
   * @return A random integer representing the result of the dice roll.
   */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }
  /**
   * Increases the character's number of stars by a specific value.
   *
   * @param value The number of stars to increase. Must be a positive integer greater than 0.
   */
  def increaseStars(value: Int): Unit = {
    currStars += value
  }

  /**
   * Decreases the character's number of stars by a specific value.
   *
   * @param value The number of stars to decrease. Must be a positive integer greater than 0.
   */
  def decreaseStars(value: Int): Unit = {
    currStars -= value
  }

  /**
   * Decreases the character's health points by a specific value.
   *
   * @param value The number of health points to decrease. Must be a positive integer.
   */
  def decreaseHp(value: Int): Unit = {
    currHp -= value
  }

  /**
   * Increases the character's health points by a specific value.
   *
   * @param value The number of health points to increase. Must be a positive integer and not exceed maxHp.
   */
  def increaseHp(value: Int): Unit = {
    currHp += value
  }
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
  def attackCharacter(value: Int): Int = {
    var finalValue: Int = value + attack
    if (finalValue <= 0) finalValue = 0
    finalValue
  }
  /**
   * Performs a defensive action against an incoming attack, considering the attack damage and value.
   *
   * When a character is subjected to an attack, this method allows the character to defend themselves.
   * The method takes into account the damage inflicted by the incoming attack (atkDamage) and the specific
   * defensive action value (value) chosen by the character to determine the outcome of the defense.
   *
   * @param atkDamage The damage inflicted by the incoming attack. Should be a positive integer representing the strength of the attack.
   * @param value     The value associated with the character's defensive action.
   * @return An integer representing the result of the defense action. This value may reflect the amount of damage mitigated or other defensive effects.
   */
  def defendCharacter(atkDamage: Int, value: Int): Int = {
    val finalDefense: Int = math.max(1, atkDamage - (value + defense))
    finalDefense
  }
  /**
   * Attempts to avoid an incoming attack with a given damage and value, and returns the result.
   *
   * This method enables the character to make an evasion attempt to avoid or mitigate an incoming attack.
   * The method takes into account the attack's damage (atkDamage) and the specific evasion value (value) chosen
   * by the character to calculate the outcome of the evasion attempt.
   *
   * @param atkDamage The damage inflicted by the incoming attack. Should be a positive integer representing the strength of the attack.
   * @param value     The value associated with the character's evasion attempt.
   * @return An integer representing the result of the evasion action, which may include the extent of damage avoided or other evasion-related effects.
   */
  def avoidCharacter(atkDamage: Int, value: Int): Int = {
    var finalAvoid: Int = atkDamage
    if (evasion + value > atkDamage) finalAvoid = 0
    finalAvoid
  }
  /**
   * Awards stars to the character as a result of a successful interaction with a player character.
   *
   * This method is invoked when the character wins stars in an interaction with a player character.
   *
   * @param player The player character with whom the interaction results in winning stars.
   */
  def winStarsVsPlayer(player: PlayerCharacter): Unit = {
    val starsValue: Int = math.floorDiv(player.currStars, 2)
    increaseStars(starsValue)
    player.decreaseStars(starsValue)
  }
  /**
   * Awards stars to the character as a result of a successful interaction with a Chicken.
   *
   * This method is called when the character wins stars in an interaction with a Chicken.
   *
   * @param chicken The Chicken character with whom the interaction results in winning stars.
   */
  def winStarsVsChicken(chicken: Chicken): Unit = {}
  /**
   * Awards stars to the character as a result of a successful interaction with a RoboBall.
   *
   * This method is invoked when the character wins stars in an interaction with a RoboBall.
   *
   * @param roboBall The RoboBall character with whom the interaction results in winning stars.
   */
  def winStarsVsRoboBall(roboBall: RoboBall): Unit = {}
  /**
   * Awards stars to the character as a result of a successful interaction with a Seagull.
   *
   * This method is called when the character wins stars in an interaction with a Seagull.
   *
   * @param seagull The Seagull character with whom the interaction results in winning stars.
   */
  def winStarsVsSeagull(seagull: Seagull): Unit = {}
  /**
   * Handles the character winning a battle or interaction against a player character.
   *
   * This method is invoked when the character wins a battle or interaction against a player character.
   *
   * @param player The player character against whom the interaction results in winning.
   */
  def winVsPlayer(player: PlayerCharacter): Unit = {}
  /**
   * Handles the character winning a battle or interaction against a Chicken.
   *
   * This method is called when the character wins a battle or interaction against a Chicken.
   *
   * @param chicken The Chicken character against whom the interaction results in winning.
   */
  def winVsChicken(chicken: Chicken): Unit = {}
  /**
   * Handles the character winning a battle or interaction against a RoboBall.
   *
   * This method is invoked when the character wins a battle or interaction against a RoboBall.
   *
   * @param roboBall The RoboBall character against whom the interaction results in winning.
   */
  def winVsRoboBall(roboBall: RoboBall): Unit = {}
  /**
   * Handles the character winning a battle or interaction against a Seagull.
   *
   * This method is called when the character wins a battle or interaction against a Seagull.
   *
   * @param seagull The Seagull character against whom the interaction results in winning.
   */
  def winVsSeagull(seagull: Seagull): Unit = {}

  private var _knockedOut: Boolean = false
  /**
   * Indicates whether the character is knocked out.
   */
  def knockedOut: Boolean = _knockedOut
  /**
   * Sets the knocked out state of the character.
   *
   * @param newKnockedOut The new knocked out state to set.
   */
  def knockedOut_=(newKnockedOut: Boolean): Unit = {
    _knockedOut = newKnockedOut
  }
  /**
   * Checks if the character is knocked out and updates the knocked out state accordingly.
   */
  def knockCharacter(): Unit = {
    if (currHp == 0) knockedOut = true
  }
  /**
   * Transfers stars from the character to another character in the game.
   *
   * If the character is knocked out, stars are transferred to the specified character.
   *
   * @param character The character to whom stars are transferred.
   */
  def transferStarsTo(character: Character): Unit = {
    knockCharacter()
    if (knockedOut) loseStarsAgainst(character)
  }
  /**
  * Grants a victory to another character in the game.
  *
  * If the character is knocked out, a victory is given to the specified character.
  *
  * @param character The character to whom the victory is given.
    */
  def giveVicTo(character: Character): Unit = {
    knockCharacter()
    if (knockedOut) loseAgainst(character)
  }
}