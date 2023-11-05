package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacter(name: String,
                        maxHp: Int,
                        attack: Int,
                        defense: Int,
                        evasion: Int,
                        randomNumberGenerator: Random = new Random()) extends AbstractCharacter(name, maxHp, attack, defense, evasion, randomNumberGenerator){

  override def transferStars(player: PlayerCharacter): Unit = {
    if (knockedOut) {
      val value: Int = currStars
      player.increaseStars(value)
    }
  }

  override def transferVictories(player: PlayerCharacter): Unit = {
    if (knockedOut) {
      player.increaseVictories(1)
    }
  }
}
