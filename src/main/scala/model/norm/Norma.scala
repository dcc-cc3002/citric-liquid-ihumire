package cl.uchile.dcc.citric
package model.norm

import cl.uchile.dcc.citric.model.units.PlayerCharacter

trait Norma {
  def checkBoost(player: PlayerCharacter): Norma

  def toNumber(): Int
}
