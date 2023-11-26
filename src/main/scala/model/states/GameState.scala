package cl.uchile.dcc.citric
package model.states

trait GameState {
  def newGame(): Unit

  def rollDice(): Unit

  def doEffect(): Unit
}
