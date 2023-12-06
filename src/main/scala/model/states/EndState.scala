package cl.uchile.dcc.citric
package model.states

import model.controller.GameController
/**
 * Represents the end state of the game.
 *
 * In this state, the game has reached its conclusion, and specific actions or events related to the end of the game
 * can be performed. This state is responsible for managing the conclusion of the game and any associated cleanup or
 * finalization procedures.
 *
 * @param controller The game controller responsible for managing the game state transitions.
 */
class EndState(controller: GameController) extends AbsGameState {

}
