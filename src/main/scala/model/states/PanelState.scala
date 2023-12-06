package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

/**
 * Represents the state where players are in a panel and an effect is applied.
 *
 * In this state, players are in a panel, and an effect is applied to them. The state provides a method to handle
 * applying the effect and transitions the game state to the chapter state.
 *
 * @param controller The game controller responsible for managing the game state transitions.
 */
class PanelState(controller: GameController) extends AbsGameState{
  /**
   * Handles the application of an effect to players while in a panel.
   * This method is called when players are in a panel, and an effect needs to be applied.
   * The game state transitions to the chapter state after applying the effect.
   */
  override def applyEffect(): Unit = {
    controller.state = new ChapterState(controller)
  }
}

