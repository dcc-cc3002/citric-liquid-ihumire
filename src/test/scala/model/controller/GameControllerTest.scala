package cl.uchile.dcc.citric
package model.controller

import model.states.{ChapterState, PreGameState}

class GameControllerTest extends munit.FunSuite {
  private var controller: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()
  }

  test("The Controller have an initial state"){
    assert(controller.state.isInstanceOf[PreGameState])
  }

  test("The controller can start a new game"){
    controller.newGame()
    assert(controller.state.isInstanceOf[ChapterState])
  }

  test("The controller change to the correct state by roll a dice"){
    controller.rollDice()
  }
}