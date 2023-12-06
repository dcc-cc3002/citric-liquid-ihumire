package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

/**
 * Represents the state where characters are recovering from being knocked out.
 *
 * In this state, characters have the opportunity to recover by rolling the dice. The outcome of the dice roll determines
 * whether the character successfully recovers and returns to the player turn state or remains knocked out and transitions
 * back to the chapter state.
 *
 * @param controller The game controller responsible for managing the game state transitions.
 */
class RecoveryState(controller: GameController) extends AbsGameState {
  /**
   * Handles the roll of the dice during the recovery state.
   * If the dice roll is sufficient, the state transitions to the player turn state. Otherwise, it transitions back to the chapter state.
   */
  override def suffRoll(): Unit = {
    controller.state = new PlayerTurnState(controller)
  }

  /**
   * Handles the case where a character is still knocked out.
   * If the character remains knocked out, the state transitions back to the chapter state.
   */
  override def stillKo(): Unit = {
    controller.state = new ChapterState(controller)
  }
}

