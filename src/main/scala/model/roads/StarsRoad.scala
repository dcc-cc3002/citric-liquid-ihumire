package cl.uchile.dcc.citric
package model.roads

class StarsRoad extends Road {
  def clearRoad(road: Road): Road = road.makeRoad()
  def makeRoad(): Road = new StarsRoad
}