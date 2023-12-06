package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

/**
 * Represents the game state during a chapter.
 *
 * This state is responsible for handling transitions and actions that occur
 * specifically during a chapter in the game.
 *
 * @param controller The game controller managing the game state.
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class ChapterState(controller: GameController) extends AbsGameState {
  /**
   * Advances to a new chapter.
   *
   * This implementation increments the current chapter of the game controller.
   */
  override def newChapter(): Unit = {
    controller.currChapter += 1
  }

  /**
   * Initiates a player's turn.
   *
   * This implementation transitions to the player's turn state.
   */
  override def playTurn(): Unit = {
    controller.state = new PlayerTurnState(controller)
  }

  /**
   * Handles a knockout situation.
   *
   * This implementation transitions to the recovery state.
   */
  override def ko(): Unit = {
    controller.state = new RecoveryState(controller)
  }

  /**
   * Handles reaching Norma 6.
   *
   * This implementation transitions to the end state.
   */
  override def normaSixReach(): Unit = {
    controller.state = new EndState(controller)
  }
}
