package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class CombatState(controller: GameController) extends AbsGameState {
  override def attackCharacter(): Unit = {
    controller.state = new ResponseState(controller)
  }

  override def endCombat(): Unit = {
    controller.state = new PanelState(controller)
  }
}
