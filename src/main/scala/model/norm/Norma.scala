package cl.uchile.dcc.citric
package model.norm

import cl.uchile.dcc.citric.model.units.PlayerCharacter

trait Norma {
  def checkBoost(valueRoad: Int, valueStars: Int, valueVictories: Int): Boolean
  def upgrade(): Norma
  def toNumber(): Int
}
