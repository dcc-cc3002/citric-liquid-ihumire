package cl.uchile.dcc.citric
package model.norm

class Norma5 extends Norma {
  def checkBoost(road: Int, stars: Int, victories: Int): Boolean = {
    var shouldBoost: Boolean = false
    if (road == 1) {
      if (stars >= 200) {
        shouldBoost = true
      }
      shouldBoost
    }
    else {
      if (victories >= 14) {
        shouldBoost = true
      }
      shouldBoost
    }
  }

  def upgrade(): Norma = new Norma6

  def toNumber(): Int = 5
}
