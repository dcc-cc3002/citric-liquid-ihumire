package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma1 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = this


    /*
    if (player.currStars >= 10 || player.currVictories >= 1) {
      new Norma2
    }
    else {
      this
    }*/

  def toNumber(): Int = 1
}
