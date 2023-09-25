package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class WildUnitCharacter(val name: String,
                        val maxHp: Int,
                        var currHp: Int,
                        val attack: Int,
                        val defense: Int,
                        val evasion: Int,
                        var currStars: Int,
                        val randomNumberGenerator: Random = new Random()) extends AbstractCharacter {

}
