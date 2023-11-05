package cl.uchile.dcc.citric
package model.roads

import model.norm.Norma
import model.units.PlayerCharacter

class VictoriesRoad extends Road{
  def clearRoad(road: Road): Road = road.makeRoad()
  def makeRoad(): Road = new VictoriesRoad
  def myRoad(norm: Norma, player: PlayerCharacter): Norma = norm.checkVictories(player)
}
