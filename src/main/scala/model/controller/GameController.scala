package cl.uchile.dcc.citric
package model.controller

import cl.uchile.dcc.citric.model.states.{AbsGameState, GameState, PreGameState}

class GameController extends{
  // Estado actual del juego
  var state: GameState = new PreGameState(this)

  def newGame(): Unit = {
    state.newGame()
  }

  def rollDice(): Unit = {
    state.rollDice()
  }

  def doEffect(): Unit = {
    /* ... */
  }
}
