package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/** Represents the constants and methods of any type of character.
 *
 * This abstract class provides the most elemental methods that any type of character
 * should have:
 * - Roll a dice
 * - Increase or decrease his amount of stars.
 * - Increase or decrease the health points in the specific moment of the game.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
abstract class AbstractCharacter(val name: String,
                                 val maxHp: Int,
                                 val attack: Int,
                                 val defense: Int,
                                 val evasion: Int,
                                 val randomNumberGenerator: Random) extends Character {
  private var _currHp: Int = maxHp

  def currHp: Int = _currHp

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

  def currStars: Int = _currStars


  def currStars_=(newCurrStars: Int): Unit = {
    _currStars = math.max(0, newCurrStars)
  }

  /**
   * Rolls a dice and returns a value between 1 to 6.
   */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /**
   * A character increase his amount of stars by a specific value.
   *
   * @param value The number of stars given to the character bigger than 0.
   */
  def increaseStars(value: Int): Unit = {
    currStars += value
  }

  /**
   * A character decrease his amount of stars by a specific value.
   *
   * @param value The number of stars drop it by the character bigger than 0.
   */
  def decreaseStars(value: Int): Unit = {
    currStars -= value
  }

  /**
   * A character decrease his health points by a specific value.
   *
   * @param value The number of health points, bigger than 0, steal to the character at least 0.
   */
  def decreaseHp(value: Int): Unit = {
    currHp -= value
  }

  /**
   * A character increase his health points by a specific value.
   *
   * @param value The number of health points, bigger than 0, given to the character less than maxHp.
   */
  def increaseHp(value: Int): Unit = {
    currHp += value
  }

  def attackCharacter(value: Int): Int = {
    var finalValue: Int = value + attack
    if (finalValue <= 0) finalValue = 0
    finalValue
  }

  def defendCharacter(atkDamage: Int, value: Int): Int = {
    val finalDefense: Int = math.max(1, atkDamage - (value + defense))
    finalDefense
  }

  def avoidCharacter(atkDamage: Int, value: Int): Int = {
    var finalAvoid: Int = atkDamage
    if (evasion + value > atkDamage) finalAvoid = 0
    finalAvoid
  }

  def winStarsVsPlayer(player: PlayerCharacter): Unit = {
    val starsValue: Int = math.floorDiv(player.currStars, 2)
    increaseStars(starsValue)
    player.decreaseStars(starsValue)
  }

  def winStarsVsChicken(chicken: Chicken): Unit = {}

  def winStarsVsRoboBall(roboBall: RoboBall): Unit = {}

  def winStarsVsSeagull(seagull: Seagull): Unit = {}

  def winVsPlayer(player: PlayerCharacter): Unit = {}

  def winVsChicken(chicken: Chicken): Unit = {}

  def winVsRoboBall(roboBall: RoboBall): Unit = {}

  def winVsSeagull(seagull: Seagull): Unit = {}

  private var _knockedOut: Boolean = false

  def knockedOut: Boolean = _knockedOut

  def knockedOut_=(newKnockedOut: Boolean): Unit = {
    _knockedOut = newKnockedOut
  }

  def knockCharacter(): Unit = {
    if (currHp == 0) knockedOut = true
  }

  def transferStarsTo(character: Character): Unit = {
    knockCharacter()
    if (knockedOut) loseStarsAgainst(character)
  }

  def giveVicTo(character: Character): Unit = {
    knockCharacter()
    if (knockedOut) loseAgainst(character)
  }
}