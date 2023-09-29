package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacter(name: String,
                        maxHp: Int,
                        attack: Int,
                        defense: Int,
                        evasion: Int,
                        randomNumberGenerator: Random = new Random()) extends AbstractCharacter (name, maxHp, attack, defense, evasion, randomNumberGenerator) {
  var currHp: Int = maxHp
  var currStars: Int = 0
  var death: Boolean = false

  def shouldBeDeath(): Unit = {
    if (currHp == 0) {
      death = true
    }
  }
}
