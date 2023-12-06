package cl.uchile.dcc.citric
package model.controller

import cl.uchile.dcc.citric.model.observable.Subject
import cl.uchile.dcc.citric.model.observer.Observer
import cl.uchile.dcc.citric.model.states.{AbsGameState, ChapterState, GameState, PreGameState}
import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ListBuffer

class GameController extends Observer {
  private var _state: GameState = new PreGameState(this)
  def state: GameState = _state
  def state_=(newState: GameState): Unit = {
    _state = newState
  }

  private var _currChapter: Int = 1
  def currChapter: Int = _currChapter

  def currChapter_=(newCurrChapter: Int): Unit = {
    _currChapter = newCurrChapter
  }

  def update(observable: Subject, value: Any): Unit = {
    println("Norma six reach by " + observable)
    normaSixReach()
  }

  def startNewGame(): Unit = {
    val players: ListBuffer[PlayerCharacter] = ListBuffer[PlayerCharacter]()
    var player1: PlayerCharacter = new PlayerCharacter("Molly", 5, 2, 1, 1)
    var player2: PlayerCharacter = new PlayerCharacter("Kira", 5, 2, -2, 1)
    var player3: PlayerCharacter = new PlayerCharacter("Luna", 5, 1, 0, 2)
    var player4: PlayerCharacter = new PlayerCharacter("Erick", 5, 0, 3, -1)
  }
  def newGame(): Unit = state.newGame()

  def newChapter(): Unit = state.newChapter()

  def playTurn(): Unit = state.playTurn()

  def ko(): Unit = state.ko()

  def normaSixReach(): Unit = state.normaSixReach()

  def rollDice(): Unit = state.rollDice()

  def suffRoll(): Unit = state.suffRoll()

  def stillKo(): Unit = state.stillKo()

  def chooseDirection(): Unit = state.chooseDirection()

  def stopEarly(): Unit = state.stopEarly()

  def notMoves(): Unit = state.notMoves()

  def attacking(): Unit = state.attacking()

  def defending(): Unit = state.defending()

  def avoiding(): Unit = state.avoiding()

  def endCombat(): Unit = state.endCombat()

  def applyEffect(): Unit = state.applyEffect()
}
