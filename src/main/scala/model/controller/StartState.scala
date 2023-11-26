package cl.uchile.dcc.citric
package model.controller

class StartState(controller: GameController) extends GameState {
  override def startGame(): Unit = {
    /* ... */
    controller.state = new /* ... */
  }

  override def rollDice(): Unit = {
    /* ... */
    controller.state = new /* ... */
  }

  override def doEffect(): Unit = {
    /* ... */
    controller.state = new /* ... */
  }
}
