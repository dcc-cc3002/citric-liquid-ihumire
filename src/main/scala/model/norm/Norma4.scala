package cl.uchile.dcc.citric
package model.norm

class Norma4 extends Norma {
  def checkBoost(road: Int, stars: Int, victories: Int): Boolean = {
    var shouldBoost: Boolean = false
    if (road == 1) {
      if (stars >= 120) {
        shouldBoost = true
      }
      shouldBoost
    }
    else {
      if (victories >= 10) {
        shouldBoost = true
      }
      shouldBoost
    }
  }

  def upgrade(): Norma = new Norma5

  def toNumber(): Int = 4
}
