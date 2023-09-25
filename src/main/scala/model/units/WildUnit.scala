package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnit(val name: String,
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

}
