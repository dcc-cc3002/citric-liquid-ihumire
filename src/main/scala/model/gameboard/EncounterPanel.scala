package cl.uchile.dcc.citric
package model.gameboard

import model.units.{Character,AbstractCharacter,Chicken, RoboBall, Seagull}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/** The `EncounterPanel` class represents a panel in the game.
 *
 * This class have a list where the wild unit will live.
 * A wild unit can get into or be removing of this panel.
 * Also, the panel wil check if the wild unit is alive. If the wild unit is death, it will be remove.
 * For the future, this specific panel will spawn a random WildUnit until the characters defeat him.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class EncounterPanel extends AbstractPanel {
  /** Array of the wild unit currently positioned on this panel.
   *
   * In the game, a single wild unit might be on the panel until a player defeat him.
   *
   */
  val wildUnitInPanel: ArrayBuffer[Character] = new ArrayBuffer[Character]()
  /** Adds a random wild unit to the list of wildUnits only if is empty.
   *
   * This might be invoked once time when a player moves to this panel to have a fight with the
   * wild unit into them.
   *
   */
  def addRandomWildUnit(): Unit = {
    if (wildUnitInPanel.isEmpty) {
      val enemies = ArrayBuffer[Character](new Chicken,new RoboBall(), new Seagull())
      val randomNumber: Random = new Random()
      wildUnitInPanel.addOne(enemies(randomNumber.nextInt(enemies.length)))
    }
  }

  /** Remove the wild unit
   */
  def removeWildUnit(): Unit = {
    if (wildUnitInPanel.nonEmpty){
      wildUnitInPanel.remove(0)
    }
  }
}
