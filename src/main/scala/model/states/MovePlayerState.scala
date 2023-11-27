package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class MovePlayerState(controller: GameController) extends AbsGameState{

  override def chooseDirection(): Unit = {}
  override def stopEarly(): Unit = {
    controller.state = new CombatState(controller)
  }

  override def notMoves(): Unit = {
    controller.state = new CombatState(controller)
  }

}
