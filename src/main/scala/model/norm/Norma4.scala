package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

class Norma4 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma4
    if (player.currStars >= 120) norm = new Norma5
    norm
  }

  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma4
    if (player.currVictories >= 10) norm = new Norma5
    norm
  }

  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma4
    if (player.currStars >= 120) norm = new Norma5
    else if (player.currVictories >= 10) norm = new Norma5
    norm
  }

  def toNumber(): Int = 4
}
