package cl.uchile.dcc.citric
package model.norm

import cl.uchile.dcc.citric.model.roads.{AllRoads, Road, StarsRoad, VictoriesRoad}
import cl.uchile.dcc.citric.model.units.PlayerCharacter

trait Norma {
  def checkBoost(player: PlayerCharacter): Norma
  def checkStars(player: PlayerCharacter): Norma
  def checkVictories(player: PlayerCharacter): Norma
  def checkAll(player: PlayerCharacter): Norma
  def toNumber(): Int
}
