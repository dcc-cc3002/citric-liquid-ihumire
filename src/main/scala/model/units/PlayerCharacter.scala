package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norm.{Norma, Norma1, Norma2, Norma3}

import scala.util.Random

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Advance their norma level.
 *
  * - Increase their victories count.
 *
  * - Clear his norma if have the possibility to glow up.
 *
  * - Recognize the KO if his current health points are 0.
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
  */
class PlayerCharacter(name: String,
                      maxHp: Int,
                      attack: Int,
                      defense: Int,
                      evasion: Int,
                      randomNumberGenerator: Random = new Random()) extends AbstractCharacter (name, maxHp, attack, defense, evasion, randomNumberGenerator) {

  private var _currNorma: Norma = new Norma1
  def currNorma: Norma = _currNorma
  def currNorma_=(newNorma: Norma): Unit = {
    _currNorma = newNorma
  }
  private var _currVictories: Int = 0
  def currVictories: Int = _currVictories
  def currVictories_=(newCurrVictories: Int): Unit = {
    _currVictories = newCurrVictories
  }
  private var _currRoad: Int = 1
  def currRoad: Int = _currRoad
  def currRoad_=(newCurrRoad: Int): Unit = {
    _currRoad = newCurrRoad
  }
  def changeRoad(value: Int): Unit = {
    if (value == 1 || value == 2) currRoad = value
  }
  /**
   * The character increase his amount of victories by one.
   */
  def increaseVictories(value: Int): Unit = {
    currVictories+=value
  }
  def normaToNumber(): Int = {
    val value: Int = currNorma.toNumber()
    value
  }
  def normaClear(): Unit = {
    val boost = currNorma.checkBoost(currRoad, currStars, currVictories)
    if (boost) currNorma = currNorma.upgrade()
  }
}