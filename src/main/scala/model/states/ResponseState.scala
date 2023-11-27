package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class ResponseState(controller:GameController) extends AbsGameState {
  override def defending(): Unit = {
    controller.state = new CombatState(controller)
  }

  override def avoiding(): Unit = {
    controller.state = new CombatState(controller)
  }
}
