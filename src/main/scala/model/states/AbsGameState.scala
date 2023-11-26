package cl.uchile.dcc.citric
package model.states

abstract class AbsGameState extends GameState{
  protected var currChapter: Int = 1
  def newGame(): Unit = {}
  def newChapter(): Unit = {}
  def playTurn(): Unit = {}
  def ko(): Unit = {}
  def normaSixReach(): Unit = {}
  def rollDice(): Unit = {}
  def doEffect(): Unit = {}
}
