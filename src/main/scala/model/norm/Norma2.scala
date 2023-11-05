package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma2 extends Norma{
  def checkBoost(player: PlayerCharacter): Norma = {
    if (player.currRoad == 1) {
      if (player.currStars >= 30) {
        new Norma3
      }
      else{
        this
      }
    }
    else {
      if (player.currVictories >= 3) {
        new Norma3
      }
      else {
        this
      }
    }
  }
  def toNumber(): Int = 2
}
