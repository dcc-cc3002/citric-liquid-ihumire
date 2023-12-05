package cl.uchile.dcc.citric
package model.controller

import model.states.{ChapterState, CombatState, EndState, MovePlayerState, PanelState, PlayerTurnState, PreGameState, RecoveryState, ResponseState}

class GameControllerTest extends munit.FunSuite {
  private var controller: GameController = _
  private var chapter: ChapterState = _
  private var combat: CombatState = _
  private var end: EndState = _
  private var movePlayer: MovePlayerState = _
  private var panel: PanelState = _
  private var playerTurn: PlayerTurnState = _
  private var preGame: PreGameState = _
  private var recovery: RecoveryState = _
  private var response: ResponseState = _
  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()
    chapter = new ChapterState(controller)
    combat = new CombatState(controller)
    end = new EndState(controller)
    movePlayer = new MovePlayerState(controller)
    panel = new PanelState(controller)
    playerTurn = new PlayerTurnState(controller)
    preGame = new PreGameState(controller)
    recovery = new RecoveryState(controller)
    response = new ResponseState(controller)
  }

  test("The controller have an initial state"){
    assert(controller.state.isInstanceOf[PreGameState])
  }

  test("The controller can start a new game"){
    controller.newGame()
    assert(controller.state.isInstanceOf[ChapterState])
  }

  test("The controller "){
    controller.newGame()

  }
}