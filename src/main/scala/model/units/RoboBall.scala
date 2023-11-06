package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class RoboBall(name: String,
               maxHp: Int,
               attack: Int,
               defense: Int,
               evasion: Int,
               randomNumberGenerator: Random) extends AbstractCharacter (name, maxHp, attack, defense, evasion, randomNumberGenerator){
  def this() = {
    this("RoboBall", 3, -1, 1, -1, new Random())
    this.increaseStars(2)
  }

  def loseStarsAgainst(character: Character): Unit = character.winStarsVsRoboBall(this)
  def loseAgainst(character: Character): Unit = character.winVsRoboBall(this)
}
