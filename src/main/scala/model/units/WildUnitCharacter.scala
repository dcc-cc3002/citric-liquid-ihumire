package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacter(name: String,
                        maxHp: Int,
                        attack: Int,
                        defense: Int,
                        evasion: Int,
                        randomNumberGenerator: Random) extends AbstractCharacter (name, maxHp, attack, defense, evasion, randomNumberGenerator) {
  private var _death: Boolean = false
  def death: Boolean = _death
  def death_=(newDeath: Boolean): Unit = {
    _death = (currHp == 0)
  }

  def killWildUnit(): Unit = {
    if (currHp == 0) {
      death = true
    }
  }
}
