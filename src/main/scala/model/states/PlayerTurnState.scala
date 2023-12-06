package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

/**
 * Represents the state where players take their turns and roll the dice.
 *
 * In this state, players take their turns and roll the dice to determine their actions. The state transitions to the
 * move player state after the dice roll, where players can choose directions or engage in combat.
 *
 * @param controller The game controller responsible for managing the game state transitions.
 */
class PlayerTurnState(controller: GameController) extends AbsGameState {
  /**
   * Handles the roll of the dice during a player's turn.
   * This method is called when players are taking their turns and need to roll the dice. After rolling the dice,
   * the game state transitions to the move player state, where players can choose directions or engage in combat.
   */
  override def rollDice(): Unit = {
    controller.state = new MovePlayerState(controller)
  }
}