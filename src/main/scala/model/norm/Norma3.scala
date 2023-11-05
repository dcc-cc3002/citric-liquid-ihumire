package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma3 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = {
    if (player.currRoad == 1) {
      if (player.currStars >= 70) {
        new Norma4
      }
      else {
        this
      }
    }
    else {
      if (player.currVictories >= 6) {
        new Norma4
      }
      else {
        this
      }
    }
  }
  def toNumber(): Int = 3
}
