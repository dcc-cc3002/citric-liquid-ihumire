package cl.uchile.dcc.citric
package model.states

import exceptions.InvalidActionException
/**
 * An abstract class representing the common structure of game states.
 *
 * This class provides default implementations for various game state transitions,
 * throwing an `InvalidActionException` for any invalid transitions. It also includes
 * placeholders for specific game actions that can be overridden in concrete subclasses.
 *
 * @throws InvalidActionException if an invalid transition is attempted.
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
abstract class AbsGameState extends GameState{
  private var _currChapter: Int = 1

  /**
   * Gets the current chapter of the game.
   *
   * @return The current chapter.
   */
  def currChapter: Int = _currChapter

  /**
   * Sets the current chapter of the game.
   *
   * @param newCurrChapter The new current chapter.
   */
  def currChapter_=(newCurrChapter: Int): Unit = {
    _currChapter = newCurrChapter
  }

  /**
   * Throws an exception for invalid transitions.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def invalidTransition(): Unit = throw new InvalidActionException("Invalid Transition")

  /**
   * Initiates a new game.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def newGame(): Unit = {
    invalidTransition()
  }

  /**
   * Advances to a new chapter.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def newChapter(): Unit = {
    invalidTransition()
  }

  /**
   * Initiates a player's turn.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def playTurn(): Unit = {
    invalidTransition()
  }

  /**
   * Handles a knockout situation.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def ko(): Unit = {
    invalidTransition()
  }

  /**
   * Handles reaching Norma 6.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def normaSixReach(): Unit = {
    invalidTransition()
  }

  /**
   * Rolls the dice during a turn.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def rollDice(): Unit = {
    invalidTransition()
  }

  /**
   * Handles a successful roll.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def suffRoll(): Unit = {
    invalidTransition()
  }

  /**
   * Handles the situation where a character is still knocked out.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def stillKo(): Unit = {
    invalidTransition()
  }

  /**
   * Allows the player to choose a direction.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def chooseDirection(): Unit = {
    invalidTransition()
  }

  /**
   * Handles the situation where player wants to stop moving early.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def stopEarly(): Unit = {invalidTransition()}

  /**
   * Handles the situation where there are no valid moves.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def notMoves(): Unit = {
    invalidTransition()
  }

  /**
   * Initiates an attack during combat.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def attacking(): Unit = {
    invalidTransition()
  }

  /**
   * Defends against an attack during combat.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def defending(): Unit = {
    invalidTransition()
  }

  /**
   * Attempts to avoid an attack during combat.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def avoiding(): Unit = {
    invalidTransition()
  }

  /**
   * Ends the combat phase.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def endCombat(): Unit = {
    invalidTransition()
  }

  /**
   * Applies the effects of an action.
   *
   * @throws InvalidActionException if an invalid transition is attempted.
   */
  def applyEffect(): Unit = {
    invalidTransition()
  }
}
