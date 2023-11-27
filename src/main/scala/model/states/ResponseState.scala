package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class ResponseState(controller:GameController) extends AbsGameState {
  override def defendCharacter(): Unit = {
    controller.state = new CombatState(controller)
  }

  override def avoidCharacter(): Unit = {
    controller.state = new CombatState(controller)
  }
}
