package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

class PreGameTest extends munit.FunSuite {
  private var controller: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()
  }

  test("xd"){
  }
}