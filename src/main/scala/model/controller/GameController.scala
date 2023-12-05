package cl.uchile.dcc.citric
package model.controller

import cl.uchile.dcc.citric.model.states.{AbsGameState, GameState, PreGameState, ChapterState}

class GameController{
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
