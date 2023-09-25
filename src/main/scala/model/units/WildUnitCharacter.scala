package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacter(val name: String,
                        val maxHp: Int,
                        var currHp: Int,
                        val attack: Int,
                        val defense: Int,
                        val evasion: Int,
                        var currStars: Int,
                        val randomNumberGenerator: Random = new Random()){

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
}
