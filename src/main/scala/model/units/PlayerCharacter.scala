package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norm.{Norma, Norma1, Norma2, Norma3}
import cl.uchile.dcc.citric.model.observable.Subject
import cl.uchile.dcc.citric.model.observer.Observer
import cl.uchile.dcc.citric.model.roads.{AllRoads, Road, StarsRoad, VictoriesRoad}

import scala.collection.mutable.ListBuffer
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
                      randomNumberGenerator: Random = new Random()) extends AbstractCharacter (name, maxHp, attack, defense, evasion, randomNumberGenerator) with Subject {
  private val observers: ListBuffer[Observer] = ListBuffer[Observer]()
  def addObserver(observer: Observer): Unit = observers += observer

  def notifyObservers(response: Any) = {
    for (o <- observers) {
      o.update(this, response)
    }
  }

  private var _currNorma: Norma = new Norma1

  /**
   * The current Norma of the player character.
   */
  def currNorma: Norma = _currNorma

  /**
   * Sets the current Norma of the player character.
   *
   * @param newNorma The new Norma to set.
   */
  def currNorma_=(newNorma: Norma): Unit = {
    _currNorma = newNorma
  }

  private var _currVictories: Int = 0

  /**
   * The current number of victories of the player character.
   */
  def currVictories: Int = _currVictories

  /**
   * Sets the current number of victories of the player character.
   *
   * @param newCurrVictories The new number of victories to set.
   */
  def currVictories_=(newCurrVictories: Int): Unit = {
    _currVictories = newCurrVictories
  }

  private var _currRoad: Road = new AllRoads

  /**
   * The current road chosen by the player character.
   */
  def currRoad: Road = _currRoad

  /**
   * Sets the current road chosen by the player character.
   *
   * @param newCurrRoad The new road to set.
   */
  def currRoad_=(newCurrRoad: Road): Unit = {
    _currRoad = newCurrRoad
  }

  /**
   * Changes the player character's current road to the specified road.
   *
   * @param road The road to change to.
   */
  def changeRoad(road: Road): Unit = {
    currRoad = currRoad.clearRoad(road)
  }
  /**
   * The character increase his amount of victories by one.
   */
  def increaseVictories(value: Int): Unit = {
    currVictories+=value
  }

  /**
   * Converts the current Norma of the player character to a numerical value.
   *
   * @return The numerical value representing the current Norma.
   */
  def normaToNumber(): Int = {
    val value: Int = currNorma.toNumber()
    value
  }

  /**
   * Clears the current Norma of the player character and updates it based on specific conditions.
   */
  def normaClear(): Unit = {
    currNorma = currNorma.checkBoost(this)
  }
  /**
   * Handles the situation when the player character loses stars to another character.
   *
   * @param character The character to lose stars to.
   */
  def loseStarsAgainst(character: Character): Unit = character.winStarsVsPlayer(this)

  /**
   * Awards stars to the character as a result of a successful interaction with a Chicken.
   *
   * This method is called when the character wins stars in an interaction with a Chicken.
   *
   * @param chicken The Chicken character with whom the interaction results in winning stars.
   */
  override def winStarsVsChicken(chicken: Chicken): Unit = {
    val starsValue: Int = chicken.currStars
    increaseStars(starsValue)
    chicken.decreaseStars(starsValue)
  }

  /**
   * Awards stars to the character as a result of a successful interaction with a RoboBall.
   *
   * This method is called when the character wins stars in an interaction with a RoboBall.
   *
   * @param roboBall The RoboBall character with whom the interaction results in winning stars.
   */
  override def winStarsVsRoboBall(roboBall: RoboBall): Unit = {
    val starsValue: Int = roboBall.currStars
    increaseStars(starsValue)
    roboBall.decreaseStars(starsValue)
  }

  /**
   * Awards stars to the character as a result of a successful interaction with a Seagull.
   *
   * This method is called when the character wins stars in an interaction with a Seagull.
   *
   * @param seagull The Seagull character with whom the interaction results in winning stars.
   */
  override def winStarsVsSeagull(seagull: Seagull): Unit = {
    val starsValue: Int = seagull.currStars
    increaseStars(starsValue)
    seagull.decreaseStars(starsValue)
  }

  /**
   * Handles the character losing a battle or interaction against another character.
   *
   * This method is called when the character loses a battle or interaction against another character.
   *
   * @param character The character against whom the interaction results in losing.
   */
  def loseAgainst(character: Character): Unit = character.winVsPlayer(this)

  /**
   * Handles the character winning a battle or interaction against a player character.
   *
   * This method is invoked when the character wins a battle or interaction against a player character.
   *
   * @param player The player character against whom the interaction results in winning.
   */
  override def winVsPlayer(player: PlayerCharacter): Unit = {
    increaseVictories(2)
  }

  /**
   * Handles the character winning a battle or interaction against a Chicken.
   *
   * This method is called when the character wins a battle or interaction against a Chicken.
   *
   * @param chicken The Chicken character against whom the interaction results in winning.
   */
  override def winVsChicken(chicken: Chicken): Unit = {
    increaseVictories(1)
  }

  /**
   * Handles the character winning a battle or interaction against a RoboBall.
   *
   * This method is invoked when the character wins a battle or interaction against a RoboBall.
   *
   * @param roboBall The RoboBall character against whom the interaction results in winning.
   */
  override def winVsRoboBall(roboBall: RoboBall): Unit = {
    increaseVictories(1)
  }

  /**
   * Handles the character winning a battle or interaction against a Seagull.
   *
   * This method is called when the character wins a battle or interaction against a Seagull.
   *
   * @param seagull The Seagull character against whom the interaction results in winning.
   */
  override def winVsSeagull(seagull: Seagull): Unit = {
    increaseVictories(1)
  }
}