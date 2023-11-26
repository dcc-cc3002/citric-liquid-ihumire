package cl.uchile.dcc.citric
package model.states

abstract class AbsGameState extends GameState{
  def newGame(): Unit = { /* ... */ }
  def rollDice(): Unit = { /* ... */ }
  def doEffect(): Unit = { /* ... */ }
}
