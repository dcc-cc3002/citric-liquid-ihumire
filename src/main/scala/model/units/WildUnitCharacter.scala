package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacter(val name: String,
                        val maxHp: Int,
                        val attack: Int,
                        val defense: Int,
                        val evasion: Int,
                        val randomNumberGenerator: Random = new Random()) extends AbstractCharacter {
  var currHp: Int = maxHp
  var currStars: Int = 0
  var death: Boolean = false

  def shouldBeDeath(): Unit = {
    if (currHp == 0) {
      death = true
    }
  }
}
