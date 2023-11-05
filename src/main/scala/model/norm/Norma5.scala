package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma5 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = {
    if (player.currRoad == 1) {
      if (player.currStars >= 200) {
        new Norma6
      }
      else {
        this
      }
    }
    else {
      if (player.currVictories >= 14) {
        new Norma6
      }
      else {
        this
      }
    }
  }
  def toNumber(): Int = 5
}
