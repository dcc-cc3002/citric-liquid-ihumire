package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class PanelState(controller: GameController) extends AbsGameState {
  override def applyEffect(): Unit={
    controller.state = new ChapterState(controller)
  }
}
