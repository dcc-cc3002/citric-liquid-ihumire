package cl.uchile.dcc.citric
package model.gameboard

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.norm.Norma

import scala.collection.mutable.ArrayBuffer

/**
 * The `HomePanel` class represents a panel in the game.
 *
 * This class provides specific methods such as healing a specific player within the list of characters and
 * performing a NormaCheck.
 *
 * @param owner The owner of this home panel, represented by a PlayerCharacter.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class HomePanel(val owner: PlayerCharacter) extends AbstractPanel {
  /**
   * Apply the panel's effects, including performing a NormaCheck and healing a player character.
   *
   * @param player The player character on which the panel's effects will be applied.
   */
  override def apply(player: PlayerCharacter): Unit = {
    player.normaClear()
    player.increaseHp(1)
  }
}
