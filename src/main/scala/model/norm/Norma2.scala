package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

class Norma2 extends Norma{
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma2
    if (player.currStars >= 30) norm = new Norma3
    norm
  }

  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma2
    if (player.currVictories >= 3) norm = new Norma3
    norm
  }

  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma2
    if (player.currStars >= 30) norm = new Norma3
    else if (player.currVictories >= 3) norm = new Norma3
    norm
  }


  def toNumber(): Int = 2
}
