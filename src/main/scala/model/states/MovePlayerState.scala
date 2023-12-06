package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

/**
 * Represents the state where players are moving on the game board.
 *
 * In this state, players have the opportunity to choose a direction for their movement on the game board.
 * The state provides methods to handle player choices, determine the consequences of not moving, and transition
 * to the combat state when players decide to stop early or have no available moves.
 *
 * @param controller The game controller responsible for managing the game state transitions.
 */
class MovePlayerState(controller: GameController) extends AbsGameState {
  /**
   * Handles the player choosing a direction for their movement on the game board.
   * This method is called when players are in the process of moving.
   */
  override def chooseDirection(): Unit = {}

  /**
   * Handles the case where players decide to stop their movement early.
   * This method transitions the game state to the combat state.
   */
  override def stopEarly(): Unit = {
    controller.state = new CombatState(controller)
  }

  /**
   * Handles the case where players have no available moves.
   * This method transitions the game state to the combat state.
   */
  override def notMoves(): Unit = {
    controller.state = new CombatState(controller)
  }
}

