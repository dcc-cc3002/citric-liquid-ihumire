package cl.uchile.dcc.citric
package model.gameboard

import model.units.{Character,AbstractCharacter,Chicken, RoboBall, Seagull}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * The `EncounterPanel` class represents a panel in the game.
 *
 * This class maintains a list of wild units that may inhabit the panel. Wild units can enter or be removed from this panel,
 * and the panel will check if the wild unit is alive. If the wild unit is defeated, it will be removed.
 * In the future, this specific panel will spawn a random WildUnit until the characters defeat it.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class EncounterPanel extends AbstractPanel {
  /**
   * Array of the wild units currently positioned on this panel.
   *
   * In the game, a single wild unit might be on the panel until a player defeats it.
   */
  val wildUnitInPanel: ArrayBuffer[Character] = new ArrayBuffer[Character]()
  /**
   * Adds a random wild unit to the list of wild units only if it is empty.
   *
   * This method might be invoked when a player moves to this panel to have a fight with the
   * wild unit present on the panel.
   */
  def addRandomWildUnit(): Unit = {
    if (wildUnitInPanel.isEmpty) {
      val enemies = ArrayBuffer[Character](new Chicken,new RoboBall(), new Seagull())
      val randomNumber: Random = new Random()
      wildUnitInPanel.addOne(enemies(randomNumber.nextInt(enemies.length)))
    }
  }
  /**
   * Remove the wild unit from the panel.
   */
  def removeWildUnit(): Unit = {
    if (wildUnitInPanel.nonEmpty){
      wildUnitInPanel.remove(0)
    }
  }
}
