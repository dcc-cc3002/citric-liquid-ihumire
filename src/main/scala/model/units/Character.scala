package cl.uchile.dcc.citric
package model.units

import scala.util.Random

trait Character {
  val name: String
  val maxHp: Int
  var currHp: Int
  val attack: Int
  val defense: Int
  val evasion: Int
  var currStars: Int
  val randomNumberGenerator: Random

  def rollDice(): Int
  def increaseStars(value: Int): Unit
  def decreaseStars(value: Int): Unit
  def increaseHp(value: Int): Unit
  def decreaseHp(value: Int): Unit

}
