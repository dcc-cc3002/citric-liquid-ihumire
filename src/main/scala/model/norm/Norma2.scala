package cl.uchile.dcc.citric
package model.norm

class Norma2 extends Norma{
  def checkBoost(road: Int, stars: Int, victories: Int): Boolean = {
    var shouldBoost: Boolean = false
    if (road == 1) {
      if (stars >= 30) {
        shouldBoost = true
      }
      shouldBoost
    }
    else {
      if (victories >= 3) {
        shouldBoost = true
      }
      shouldBoost
    }
  }
  def upgrade(): Norma = new Norma3
  def toNumber(): Int = 2
}
