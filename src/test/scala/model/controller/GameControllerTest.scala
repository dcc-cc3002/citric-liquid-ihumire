package cl.uchile.dcc.citric
package model.controller

import model.states.{ChapterState, CombatState, EndState, MovePlayerState, PanelState, PlayerTurnState, PreGameState, RecoveryState, ResponseState}

class GameControllerTest extends munit.FunSuite {
  private var controller1: GameController = _
  private var controller2: GameController = _
  private var controller3: GameController = _
  private var controller4: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller1 = new GameController()
    controller2 = new GameController()
    controller3 = new GameController()
    controller4 = new GameController()
  }

  test("The controller have an initial state"){
    assert(controller1.state.isInstanceOf[PreGameState])
  }

  test("The controller pass to chapter state"){
    controller1.newGame()
    assert(controller1.state.isInstanceOf[ChapterState])
  }

  test("The controller starts a new chapter"){
    controller1.newGame()
    val expChapter: Int = controller1.currChapter + 1
    controller1.newChapter()
    assertEquals(controller1.currChapter, expChapter)
  }

  test("The controller go to different states from Chapter State"){
    // To PlayerTurnState
    controller1.newGame()
    controller1.playTurn()
    assert(controller1.state.isInstanceOf[PlayerTurnState])
    // To RecoveryState
    controller2.newGame()
    controller2.ko()
    assert(controller2.state.isInstanceOf[RecoveryState])
    // To EndState
    controller3.newGame()
    controller3.normaSixReach()
    assert(controller3.state.isInstanceOf[EndState])
    // To ChapterState
    controller4.newGame()
    controller4.newChapter()
    assert(controller4.state.isInstanceOf[ChapterState])
  }

  test("The controller go to different states from Recovery State") {
    // To ChapterState
    controller1.newGame()
    controller1.ko()
    controller1.stillKo()
    assert(controller1.state.isInstanceOf[ChapterState])
    // To PlayerTurnState
    controller2.newGame()
    controller2.ko()
    controller2.suffRoll()
    assert(controller2.state.isInstanceOf[PlayerTurnState])
  }

  test("The controller go to MovePlayer states from PlayerTurn State") {
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    assert(controller1.state.isInstanceOf[MovePlayerState])
  }

  test("The controller go to different states from MovePlayer State") {
    // To MovePlayerState
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    controller1.chooseDirection()
    assert(controller1.state.isInstanceOf[MovePlayerState])
    // To CombatState by stopEarly
    controller2.newGame()
    controller2.playTurn()
    controller2.rollDice()
    controller2.stopEarly()
    assert(controller2.state.isInstanceOf[CombatState])
    // To CombatState by notMoves
    controller3.newGame()
    controller3.playTurn()
    controller3.rollDice()
    controller3.notMoves()
    assert(controller3.state.isInstanceOf[CombatState])
  }

  test("The controller go to different states from Combat State") {
    // To ResponseState
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    controller1.stopEarly()
    controller1.attacking()
    assert(controller1.state.isInstanceOf[ResponseState])
    // To PanelState
    controller2.newGame()
    controller2.playTurn()
    controller2.rollDice()
    controller2.stopEarly()
    controller2.endCombat()
    assert(controller2.state.isInstanceOf[PanelState])
  }

  test("The controller go to different states from Response State") {
    // To CombatState by defending
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    controller1.stopEarly()
    controller1.attacking()
    controller1.defending()
    assert(controller1.state.isInstanceOf[CombatState])
    // To CombatState by avoiding
    controller2.newGame()
    controller2.playTurn()
    controller2.rollDice()
    controller2.stopEarly()
    controller2.attacking()
    controller2.avoiding()
    assert(controller2.state.isInstanceOf[CombatState])
  }

  test("The controller go to Chapter State from Panel State") {
    // To ChapterState
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    controller1.stopEarly()
    controller1.endCombat()
    controller1.applyEffect()
    assert(controller1.state.isInstanceOf[ChapterState])
  }
}