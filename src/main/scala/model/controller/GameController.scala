package cl.uchile.dcc.citric
package model.controller

import cl.uchile.dcc.citric.model.observable.Subject
import cl.uchile.dcc.citric.model.observer.Observer
import cl.uchile.dcc.citric.model.states.{AbsGameState, ChapterState, GameState, PreGameState}
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ListBuffer

/**
 * The `GameController` class manages the flow and state of the game. It acts as a mediator between the players and the game state.
 * It keeps track of the current game state, chapter, and player characters. It also implements various methods to control the game's progression.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 */
class GameController extends Observer {
  /**
   * The current state of the game.
   */
  private var _state: GameState = new PreGameState(this)
  def state: GameState = _state
  def state_=(newState: GameState): Unit = {
    _state = newState
  }

  /**
   * The current chapter of the game.
   */
  private var _currChapter: Int = 1
  def currChapter: Int = _currChapter
  def currChapter_=(newCurrChapter: Int): Unit = {
    _currChapter = newCurrChapter
  }

  /**
   * Updates the game state when notified by an observable subject.
   *
   * @param observable The observable subject that triggered the update.
   * @param value      Additional information associated with the update.
   */
  def update(observable: Subject, value: Any): Unit = {
    println("Norma six reached by " + observable)
    normaSixReach()
  }

  /**
   * List of player characters participating in the game.
   */
  val players: ListBuffer[PlayerCharacter] = ListBuffer[PlayerCharacter]()

  /**
   * Starts a new game by creating player characters and initializing the game state.
   */
  def startNewGame(): Unit = {
    val player1: PlayerCharacter = new PlayerCharacter("Molly", 5, 2, 1, 1)
    val player2: PlayerCharacter = new PlayerCharacter("Kira", 5, 2, -2, 1)
    val player3: PlayerCharacter = new PlayerCharacter("Luna", 5, 1, 0, 2)
    val player4: PlayerCharacter = new PlayerCharacter("Erick", 5, 0, 3, -1)

    players += player1
    players += player2
    players += player3
    players += player4

    for (p <- players) p.addObserver(this)
    newGame()
  }

  /**
   * Initializes a new game by setting up the initial state.
   */
  def newGame(): Unit = state.newGame()

  /**
   * Advances the game to a new chapter.
   */
  def newChapter(): Unit = state.newChapter()

  /**
   * Initiates a player's turn in the game.
   */
  def playTurn(): Unit = state.playTurn()

  /**
   * Handles a player being knocked out in the game.
   */
  def ko(): Unit = state.ko()

  /**
   * Handles a player reaching Norma six in the game.
   */
  def normaSixReach(): Unit = state.normaSixReach()

  /**
   * Rolls the dice in the game.
   */
  def rollDice(): Unit = state.rollDice()

  /**
   * Resolves the outcome of a sufficient roll in the game.
   */
  def suffRoll(): Unit = state.suffRoll()

  /**
   * Handles the case where a player is still knocked out in the game.
   */
  def stillKo(): Unit = state.stillKo()

  /**
   * Allows the player to choose a direction in the game.
   */
  def chooseDirection(): Unit = state.chooseDirection()

  /**
   * Stops the turn early in the game.
   */
  def stopEarly(): Unit = state.stopEarly()

  /**
   * Handles the case where there are no available moves in the game.
   */
  def notMoves(): Unit = state.notMoves()

  /**
   * Initiates an attack in the game.
   */
  def attacking(): Unit = state.attacking()

  /**
   * Initiates a defense action in the game.
   */
  def defending(): Unit = state.defending()

  /**
   * Initiates an avoidance action in the game.
   */
  def avoiding(): Unit = state.avoiding()

  /**
   * Ends the combat phase in the game.
   */
  def endCombat(): Unit = state.endCombat()

  /**
   * Applies the effects of the current game state.
   */
  def applyEffect(): Unit = state.applyEffect()
}

