package cl.uchile.dcc.citric
package model.roads

import model.units.PlayerCharacter
import model.norm.Norma

trait Road {
  def clearRoad(road: Road): Road
  def makeRoad(): Road
}
