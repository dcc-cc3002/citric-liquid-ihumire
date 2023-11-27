package cl.uchile.dcc.citric
package model.controller

import cl.uchile.dcc.citric.model.states.{AbsGameState, GameState, PreGameState, ChapterState}

class GameController extends{
  // Estado actual del juego
  var state: GameState = new PreGameState(this)

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
