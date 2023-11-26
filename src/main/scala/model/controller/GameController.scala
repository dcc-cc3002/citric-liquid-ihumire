package cl.uchile.dcc.citric
package model.controller

import cl.uchile.dcc.citric.model.states.{AbsGameState, GameState, PreGameState, ChapterState}

class GameController extends{
  // Estado actual del juego
  var state: GameState = new PreGameState(this)

  def newGame(): Unit = {
    state.newGame()
  }

  def newChapter(): Unit = {
    state.newChapter()
  }

  def rollDice(): Unit = {
    state.rollDice()
  }

  def doEffect(): Unit = {
  }
}
