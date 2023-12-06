package cl.uchile.dcc.citric
package model.states

/**
 * Represents the various states of the game.
 *
 * This trait defines the methods that correspond to different game actions or state transitions.
 * Classes implementing this trait will provide specific implementations for each method based on
 * the game's logic.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
trait GameState {
  /**
   * Starts a new game.
   */
  def newGame(): Unit

  /**
   * Initiates a new chapter in the game.
   */
  def newChapter(): Unit

  /**
   * Handles the player's turn.
   */
  def playTurn(): Unit

  /**
   * Manages the knockout (KO) state.
   */
  def ko(): Unit

  /**
   * Handles the achievement of Norma six.
   */
  def normaSixReach(): Unit

  /**
   * Rolls the dice in the game.
   */
  def rollDice(): Unit

  /**
   * Handles situations where a player's roll is insufficient.
   */
  def suffRoll(): Unit

  /**
   * Manages the state where a character is still knocked out.
   */
  def stillKo(): Unit

  /**
   * Allows the player to choose a direction.
   */
  def chooseDirection(): Unit

  /**
   * Stops the move early.
   */
  def stopEarly(): Unit

  /**
   * Handles situations where there are no available moves.
   */
  def notMoves(): Unit

  /**
   * Initiates the attacking phase in combat.
   */
  def attacking(): Unit

  /**
   * Initiates the defending phase in combat.
   */
  def defending(): Unit

  /**
   * Initiates the avoiding phase in combat.
   */
  def avoiding(): Unit

  /**
   * Ends the combat phase.
   */
  def endCombat(): Unit

  /**
   * Applies the effects in the current game state.
   */
  def applyEffect(): Unit
}
