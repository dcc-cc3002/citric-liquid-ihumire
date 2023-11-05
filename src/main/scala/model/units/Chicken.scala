package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class Chicken(name: String,
              maxHp: Int,
              attack: Int,
              defense: Int,
              evasion: Int,
              randomNumberGenerator: Random) extends WildUnitCharacter (name, maxHp, attack, defense, evasion, randomNumberGenerator){
  def this() = {
    this("Chicken", 3, -1, -1, 1, new Random())
    this.increaseStars(3)
  }
}
