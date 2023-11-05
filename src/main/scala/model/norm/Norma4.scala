package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma4 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = {
    if (player.currRoad == 1) {
      if (player.currStars >= 120) {
        new Norma5
      }
      else {
        this
      }
    }
    else {
      if (player.currVictories >= 10) {
        new Norma5
      }
      else {
        this
      }
    }
  }
  def toNumber(): Int = 4
}
