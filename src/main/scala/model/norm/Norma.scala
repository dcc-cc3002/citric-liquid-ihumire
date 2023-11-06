package cl.uchile.dcc.citric
package model.norm

import cl.uchile.dcc.citric.model.roads.{AllRoads, Road, StarsRoad, VictoriesRoad}
import cl.uchile.dcc.citric.model.units.PlayerCharacter
/**
 * The `Norma` trait represents a set of conditions or goals for a player character in the game.
 *
 * Player characters can pursue various normas with specific criteria, such as boosting stats, collecting stars,
 * achieving victories, or fulfilling all norma conditions.
 *
 * @see [[PlayerCharacter]]
 */
trait Norma {
  def checkBoost(player: PlayerCharacter): Norma
  def checkStars(player: PlayerCharacter): Norma
  def checkVictories(player: PlayerCharacter): Norma
  def checkAll(player: PlayerCharacter): Norma
  def toNumber(): Int
}
