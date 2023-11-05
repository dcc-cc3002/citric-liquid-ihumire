package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

class Norma3 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma3
    if (player.currStars >= 70) norm = new Norma4
    norm
  }

  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma3
    if (player.currVictories >= 6) norm = new Norma4
    norm
  }

  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma3
    if (player.currStars >= 70) norm = new Norma4
    else if (player.currVictories >= 6) norm = new Norma4
    norm
  }

  def toNumber(): Int = 3
}
