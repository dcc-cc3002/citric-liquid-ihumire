package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

/**
 * Represents the initial state of the game before players start their turns.
 *
 * In this state, the game is set up for a new game, and players transition to the chapter state to begin their adventure.
 *
 * @param controller The game controller responsible for managing the game state transitions.
 */
class PreGameState(controller: GameController) extends AbsGameState {
  /**
   * Initiates a new game.
   * This method is called when the game is in the pre-game state, and players are ready to start a new adventure.
   * The state transitions to the chapter state, where players can progress through chapters and take turns.
   */
  override def newGame(): Unit = {
    controller.state = new ChapterState(controller)
  }
}
