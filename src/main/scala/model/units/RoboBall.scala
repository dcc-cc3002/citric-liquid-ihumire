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

  def loseAgainst(character: Character): Unit = character.winsVsRoboBall(this)

  def winsVsPlayer(player: PlayerCharacter): Unit = {
    val starsValue: Int = math.floorDiv(player.currStars, 2)
    increaseStars(starsValue)
    player.decreaseStars(starsValue)
  }

  def winsVsChicken(chicken: Chicken): Unit = {
  }

  def winsVsRoboBall(roboBall: RoboBall): Unit = {
  }

  def winsVsSeagull(seagull: Seagull): Unit = {
  }
}
