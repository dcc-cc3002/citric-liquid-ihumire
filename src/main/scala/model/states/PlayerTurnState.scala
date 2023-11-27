package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class PlayerTurnState(controller: GameController) extends AbsGameState {
  override def rollDice(): Unit = {
    controller.state = new MovePlayerState(controller)
  }
}