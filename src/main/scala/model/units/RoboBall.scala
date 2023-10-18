package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class RoboBall(name: String,
               maxHp: Int,
               attack: Int,
               defense: Int,
               evasion: Int,
               randomNumberGenerator: Random) extends WildUnitCharacter (name, maxHp, attack, defense, evasion, randomNumberGenerator){
  def this() = {
    this("RoboBall", 3, -1, 1, -1, new Random())
  }

}
