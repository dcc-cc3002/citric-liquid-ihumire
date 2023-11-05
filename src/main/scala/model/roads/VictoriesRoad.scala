package cl.uchile.dcc.citric
package model.roads

class VictoriesRoad extends Road{
  def clearRoad(road: Road): Road = road.makeRoad()
  def makeRoad(): Road = new VictoriesRoad
}
