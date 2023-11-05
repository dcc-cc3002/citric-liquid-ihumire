package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma5 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = {
    var retNorma: Norma = this
    if (player.currRoad == 1) {
      if (player.currStars >= 200) retNorma = new Norma6
      retNorma
    }
    else {
      if (player.currVictories >= 14) retNorma = new Norma6
      retNorma
    }
  }

  def toNumber(): Int = 5
}