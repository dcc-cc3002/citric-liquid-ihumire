package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma2 extends Norma{
  def checkBoost(player: PlayerCharacter): Norma = {
    if (player.currRoad == 1) checkByStars(player)
    else checkByVictories(player)
  }

  def checkByStars(player: PlayerCharacter): Norma = {
    var retNorma: Norma = this
    if (player.currStars >= 30) retNorma = new Norma6
    retNorma
  }

  def checkByVictories(player: PlayerCharacter): Norma = {
    var retNorma: Norma = this
    if (player.currVictories >= 13) retNorma = new Norma6
    retNorma
  }

  def toNumber(): Int = 2
}
