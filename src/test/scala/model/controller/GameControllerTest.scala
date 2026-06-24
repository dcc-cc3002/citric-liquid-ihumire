package cl.uchile.dcc.citric
package model.controller

import model.states.{ChapterState, CombatState, EndState, MovePlayerState, PanelState, PlayerTurnState, PreGameState, RecoveryState, ResponseState}

import cl.uchile.dcc.citric.exceptions.InvalidActionException
import org.junit.Assert

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

  test("Valid Transitions from PreGameState"){
    controller1.newGame()
    assert(controller1.state.isInstanceOf[ChapterState])
  }

  test("Invalid Transitions from PregameState"){
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newChapter())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.playTurn())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.ko())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.normaSixReach())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stillKo())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.suffRoll())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.rollDice())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.chooseDirection())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stopEarly())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.notMoves())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.attacking())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.defending())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.avoiding())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.endCombat())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.applyEffect())
  }

  test("The controller starts a new chapter"){
    controller1.newGame()
    val expChapter: Int = controller1.currChapter + 1
    controller1.newChapter()
    assertEquals(controller1.currChapter, expChapter)
  }

  test("Valid Transitions from ChapterState"){
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
  test("Invalid Transitions from ChapterState") {
    controller1.newGame()
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newGame())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stillKo())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.suffRoll())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.rollDice())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.chooseDirection())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stopEarly())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.notMoves())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.attacking())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.defending())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.avoiding())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.endCombat())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.applyEffect())
  }

  test("Valid Transitions from RecoveryState") {
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

  test("Invalid Transitions from RecoveryState") {
    controller1.newGame()
    controller1.ko()
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newGame())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newChapter())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.playTurn())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.ko())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.normaSixReach())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.rollDice())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.chooseDirection())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stopEarly())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.notMoves())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.attacking())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.defending())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.avoiding())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.endCombat())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.applyEffect())
  }

  test("Valid Transitions from PlayerTurnState") {
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    assert(controller1.state.isInstanceOf[MovePlayerState])
  }
  test("Invalid Transitions from PlayerTurnState") {
    controller1.newGame()
    controller1.playTurn()
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newGame())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newChapter())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.playTurn())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.ko())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.normaSixReach())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stillKo())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.suffRoll())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.chooseDirection())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stopEarly())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.notMoves())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.attacking())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.defending())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.avoiding())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.endCombat())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.applyEffect())
  }

  test("Valid Transitions from MovePlayerState") {
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

  test("Invalid Transitions from MovePlayerState") {
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newGame())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newChapter())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.playTurn())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.ko())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.normaSixReach())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stillKo())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.suffRoll())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.rollDice())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.attacking())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.defending())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.avoiding())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.endCombat())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.applyEffect())
  }

  test("Valid Transitions from CombatState") {
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

  test("Invalid Transitions from CombatState") {
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    controller1.stopEarly()
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newGame())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newChapter())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.playTurn())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.ko())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.normaSixReach())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stillKo())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.suffRoll())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.rollDice())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.chooseDirection())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stopEarly())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.notMoves())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.defending())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.avoiding())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.applyEffect())
  }

  test("Valid Transitions from ResponseState") {
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

  test("Invalid Transitions from ResponseState") {
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    controller1.stopEarly()
    controller1.attacking()
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newGame())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newChapter())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.playTurn())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.ko())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.normaSixReach())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stillKo())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.suffRoll())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.rollDice())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.chooseDirection())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stopEarly())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.notMoves())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.attacking())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.endCombat())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.applyEffect())
  }

  test("Valid Transitions from PanelState") {
    // To ChapterState
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    controller1.stopEarly()
    controller1.endCombat()
    controller1.applyEffect()
    assert(controller1.state.isInstanceOf[ChapterState])
  }
  test("Invalid Transitions from PanelState") {
    controller1.newGame()
    controller1.playTurn()
    controller1.rollDice()
    controller1.stopEarly()
    controller1.endCombat()
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newGame())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.newChapter())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.playTurn())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.ko())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.normaSixReach())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stillKo())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.suffRoll())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.rollDice())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.chooseDirection())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.stopEarly())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.notMoves())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.attacking())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.defending())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.avoiding())
    Assert.assertThrows(classOf[InvalidActionException], () => controller1.endCombat())
  }

  test("Players have an observer"){
    controller1.startNewGame()
    for(p <- controller1.players){
      assert(p.observers(0).isInstanceOf[GameController])
    }
  }

  test("Player win by reach norma 6") {
    controller1.startNewGame()
    controller1.players(0).increaseStars(200)
    controller1.players(0).normaClear()
    controller1.players(0).normaClear()
    controller1.players(0).normaClear()
    controller1.players(0).normaClear()
    controller1.players(0).normaClear()
    assert(controller1.state.isInstanceOf[EndState])
  }
}