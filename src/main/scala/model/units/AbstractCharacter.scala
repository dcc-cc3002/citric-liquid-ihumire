package cl.uchile.dcc.citric
package model.units

import scala.util.Random

abstract class AbstractCharacter extends Character {
  /**
   * Rolls a dice and returns a value between 1 to 6.
   */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }
  /**
   * The character increase his amount of stars by a specific value.
   *
   * @param value The number of stars given to the character bigger than 0.
   */
  def increaseStars(value: Int): Unit = {
    currStars += value
  }
  /**
   * The character decrease his amount of stars by a specific value.
   *
   * @param value The number of stars drop it by the character bigger than 0.
   */
  def decreaseStars(value: Int): Unit = {
    currStars -= value
    if (currStars < 0) {
      currStars = 0
    }
  }

  /**
   * The character increase his health points by a specific value.
   *
   * @param value The number of health points, bigger than 0, given to the character less than maxHp.
   */
  def increaseHp(value: Int): Unit = {
    currHp += value
    if (currHp > maxHp) {
      currHp = maxHp
    }
  }

  /**
   * The character decrease his health points by a specific value.
   *
   * @param value The number of health points, bigger than 0, steal to the character at least 0.
   */
  def decreaseHp(value: Int): Unit = {
    currHp -= value
    if (currHp < 0) {
      currHp = 0
    }
  }
}