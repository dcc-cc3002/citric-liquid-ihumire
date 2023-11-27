package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class RecoveryState(controller: GameController) extends AbsGameState {
  override def suffRoll():Unit = {
    controller.state = new PlayerTurnState(controller)
  }

  override def stillKo(): Unit = {
    controller.state = new ChapterState(controller)
  }
}
