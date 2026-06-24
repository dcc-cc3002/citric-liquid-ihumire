package cl.uchile.dcc.citric
package model.gameboard
import model.units.PlayerCharacter

/**
 * The `NeutralPanel` class represents a panel in the game.
 *
 * This class doesn't perform any special actions or effects.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class NeutralPanel extends AbstractPanel {
  /**
   * Apply the panel's effect to a player character.
   *
   * @param player The player character on which the panel's effect will be applied.
   */
  override def apply(player: PlayerCharacter): Unit = {}
}
