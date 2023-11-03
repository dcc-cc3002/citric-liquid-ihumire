package cl.uchile.dcc.citric
package model.norm

import cl.uchile.dcc.citric.model.units.PlayerCharacter

trait Norma {
  def normaClear(player: PlayerCharacter, road: Int, value: Int): Unit
}
