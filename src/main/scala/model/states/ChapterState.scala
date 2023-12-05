package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class ChapterState(controller: GameController) extends AbsGameState {
  override def newChapter(): Unit = {
    controller.currChapter += 1
  }
  override def playTurn(): Unit = {
    controller.state = new PlayerTurnState(controller)
  }
  override def ko(): Unit = {
    controller.state = new RecoveryState(controller)
  }
  override def normaSixReach(): Unit = {
    controller.state = new EndState(controller)
  }
}
