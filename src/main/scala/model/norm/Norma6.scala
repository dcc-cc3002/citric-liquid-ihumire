package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma6 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  def checkStars(player: PlayerCharacter): Norma = this

  def checkVictories(player: PlayerCharacter): Norma = this

  def checkAll(player: PlayerCharacter): Norma = this

  override def toNumber(): Int = 6
}
