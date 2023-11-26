package cl.uchile.dcc.citric
package model.controller

class GameController {
  // Estado actual del juego
  var state: GameState = new StartState(this)

  def startGame(): Unit = {
    state.startGame()
    /* ... */
  }

  def rollDice(): Unit = {
    /* ... */
  }

  def doEffect(): Unit = {
    /* ... */
  }
}
