package cl.uchile.dcc.citric
package model.units

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
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
 *
  * - Increase or decrease their health points.
 *
  * - Increase their victories count.
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
  * @param currNorma The number of norma of the player.
  * @param currStars The number of stars of the player.
  * @param currVictories The number of victories of the player.
  * @param currRoad The objective of the player. Roads: (1) Stars objective / (2) Victories objective
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
  */
class PlayerCharacter(val name: String,
                      val maxHp: Int,
                      var currHp: Int,
                      val attack: Int,
                      val defense: Int,
                      val evasion: Int,
                      var currNorma: Int,
                      var currStars: Int,
                      var currVictories: Int,
                      var currRoad: Int,
                      val randomNumberGenerator: Random = new Random()) extends AbstractCharacter {
  var knockedOut: Boolean = false
  /**
   * The character increase his level of Norma.
   */
  def advanceNorma(): Unit = {
    if (currNorma <= 5) {
      currNorma += 1
    }
  }
  /**
   * The character increase his amount of victories by one.
   */
  def increaseVictory(): Unit = {
    currVictories+=1
  }

  /**
   * The character NormaClears his self, updating his level of norma.
   * The method considers the amount of stars, amount of victories, the level of norma
   * and the road previously chosen.
   */
  def normaClear(): Unit = {

    if (currNorma == 1) {
      if ((currStars >= 10) || (currVictories >= 1)) {
        advanceNorma()
      }
    }
    else if (currNorma == 2) {
      if ((currRoad == 1) && (currStars >= 30)) {
        advanceNorma()
      }
      else if ((currRoad == 2) && (currVictories >= 3)) {
        advanceNorma()
      }
    }

    else if (currNorma == 3) {
      if ((currRoad == 1) && (currStars >= 70)) {
        advanceNorma()
      }
      else if ((currRoad == 2) && (currVictories >= 6)) {
        advanceNorma()
      }
    }

    else if (currNorma == 4) {
      if ((currRoad == 1) && (currStars >= 120)) {
        advanceNorma()
      }
      else if ((currRoad == 2) && (currVictories >= 10)) {
        advanceNorma()
      }
    }

    else if (currNorma == 5) {
      if ((currRoad == 1) && (currStars >= 200)) {
        advanceNorma()
      }
      else if ((currRoad == 2) && (currVictories >= 14)) {
        advanceNorma()
      }
    }
  }

  def shouldKnockedOut(): Unit = {
    if (currHp == 0) {
      knockedOut = true
    }
  }
}
