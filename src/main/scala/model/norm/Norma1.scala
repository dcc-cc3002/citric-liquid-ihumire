package cl.uchile.dcc.citric
package model.norm

class Norma1 extends Norma{
  def checkBoost(road: Int, stars: Int, victories: Int): Boolean = {
    var shouldBoost: Boolean = false
    if (stars >= 10 || victories >= 1){
      shouldBoost = true
    }
    shouldBoost
  }
  def upgrade(): Norma = new Norma2

  def toNumber(): Int = 1
}
