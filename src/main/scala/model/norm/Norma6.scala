package cl.uchile.dcc.citric
package model.norm

class Norma6 extends Norma {
  def checkBoost(road: Int, stars: Int, victories: Int): Boolean = {
    true
  }

  def upgrade(): Norma = this

  override def toNumber(): Int = 6
}
