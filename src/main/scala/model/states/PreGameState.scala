package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class PreGameState(controller: GameController) extends AbsGameState {
  override def newGame(): Unit = {
    controller.state = new ChapterState(controller)
  }
}
