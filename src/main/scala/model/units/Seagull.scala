package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class Seagull(name: String,
              maxHp: Int,
              attack: Int,
              defense: Int,
              evasion: Int,
              randomNumberGenerator: Random) extends AbstractCharacter(name, maxHp, attack, defense, evasion, randomNumberGenerator) {
  def this() = {
    this("Seagull", 3, 1, -1, -1, new Random())
    this.increaseStars(2)
  }

  def loseStarsAgainst(character: Character): Unit = character.winStarsVsSeagull(this)
  def loseAgainst(character: Character): Unit = character.winVsSeagull(this)
}
