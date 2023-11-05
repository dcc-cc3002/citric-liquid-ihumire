package cl.uchile.dcc.citric
package model.roads
import model.norm.Norma
import model.units.PlayerCharacter

class AllRoads extends Road{
  def clearRoad(road: Road): Road = road.makeRoad()
  def makeRoad(): Road = new AllRoads
}
