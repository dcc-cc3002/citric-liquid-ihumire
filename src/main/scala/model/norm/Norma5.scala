package cl.uchile.dcc.citric
package model.norm

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.roads.{AllRoads, StarsRoad, VictoriesRoad}

class Norma5 extends Norma {
  def checkBoost(player: PlayerCharacter): Norma = player.currRoad.myRoad(this, player)

  def checkStars(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma5
    if (player.currStars >= 200) {
      norm = new Norma6
      player.notifyObservers("Norma six reach")
    }
    norm
  }

  def checkVictories(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma5
    if (player.currVictories >= 14) {
      norm = new Norma6
      player.notifyObservers("Norma six reach")
    }
    norm
  }

  def checkAll(player: PlayerCharacter): Norma = {
    var norm: Norma = new Norma5
    if (player.currStars >= 200) {
      norm = new Norma6
      player.notifyObservers("Norma six reach")
    }
    else if (player.currVictories >= 14) {
      norm = new Norma6
      player.notifyObservers("Norma six reach")
    }
    norm
  }


  def toNumber(): Int = 5
}