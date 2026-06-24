package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

/**
 * Represents the game state during combat.
 *
 * This state is responsible for handling transitions and actions that occur
 * specifically during combat in the game.
 *
 * @param controller The game controller managing the game state.
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class CombatState(controller: GameController) extends AbsGameState {
  /**
   * Initiates the attacking phase of combat.
   *
   * This implementation transitions to the response state.
   */
  override def attacking(): Unit = {
    controller.state = new ResponseState(controller)
  }

  /**
   * Ends the combat phase.
   *
   * This implementation transitions to the panel state.
   */
  override def endCombat(): Unit = {
    controller.state = new PanelState(controller)
  }
}
