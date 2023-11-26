package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class PreGameState(controller: GameController) extends AbsGameState {
  override def newGame(): Unit = {
    controller.state = new ChapterState()
  }

  override def rollDice(): Unit = {
    // controller.state = new
  }

  override def doEffect(): Unit = {
    /* ... */
    //controller.state = new
  }
}
