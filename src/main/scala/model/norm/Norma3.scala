package cl.uchile.dcc.citric
package model.norm

class Norma3 extends Norma {
  def checkBoost(road: Int, stars: Int, victories: Int): Boolean = {
    var shouldBoost: Boolean = false
    if (road == 1) {
      if (stars >= 70) {
        shouldBoost = true
      }
      shouldBoost
    }
    else {
      if (victories >= 6) {
        shouldBoost = true
      }
      shouldBoost
    }
  }

  def upgrade(): Norma = new Norma4

  def toNumber(): Int = 3

}
