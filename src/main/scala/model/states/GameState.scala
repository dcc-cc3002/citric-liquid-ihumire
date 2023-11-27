package cl.uchile.dcc.citric
package model.states

trait GameState {
  def newGame(): Unit

  def newChapter(): Unit

  def playTurn(): Unit

  def ko(): Unit

  def normaSixReach(): Unit

  def rollDice(): Unit

  def suffRoll(): Unit

  def stillKo(): Unit

  def chooseDirection(): Unit

  def stopEarly(): Unit

  def notMoves(): Unit

  def attackCharacter(): Unit

  def defendCharacter(): Unit

  def avoidCharacter(): Unit

  def endCombat(): Unit

  def applyEffect(): Unit

}
