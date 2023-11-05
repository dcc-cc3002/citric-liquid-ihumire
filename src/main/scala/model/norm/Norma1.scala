package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

class Norma1 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)
  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma1
    if (player.currStars >= 10) norm = new Norma2
    norm
  }

  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma1
    if (player.currVictories >= 1) norm = new Norma2
    norm
  }

  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma1
    if (player.currStars >= 10) norm = new Norma2
    else if (player.currVictories >= 1) norm = new Norma2
    norm
  }

  def toNumber(): Int = 1
}
