package cl.uchile.dcc.citric
package model.states

import exceptions.InvalidActionException

abstract class AbsGameState extends GameState{
  private var _currChapter: Int = 1
  def currChapter: Int = _currChapter
  def currChapter_=(newCurrChapter: Int): Unit = {
    _currChapter = newCurrChapter
  }

  def invalidTransition(): Unit = throw new InvalidActionException("Invalid Transition")

  def newGame(): Unit = {invalidTransition()}
  def newChapter(): Unit = {invalidTransition()}
  def playTurn(): Unit = {invalidTransition()}
  def ko(): Unit = {invalidTransition()}
  def normaSixReach(): Unit = {invalidTransition()}
  def rollDice(): Unit = {invalidTransition()}
  def suffRoll():Unit = {invalidTransition()}
  def stillKo(): Unit = {invalidTransition()}
  def chooseDirection(): Unit = {invalidTransition()}
  def stopEarly(): Unit = {invalidTransition()}
  def notMoves(): Unit = {invalidTransition()}
  def attacking(): Unit = {invalidTransition()}
  def defending(): Unit = {invalidTransition()}
  def avoiding(): Unit = {invalidTransition()}
  def endCombat(): Unit = {invalidTransition()}
  def applyEffect(): Unit = {invalidTransition()}
}
