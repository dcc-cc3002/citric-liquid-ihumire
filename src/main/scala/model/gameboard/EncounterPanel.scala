package cl.uchile.dcc.citric
package model.gameboard

import model.units.WildUnitCharacter

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
  /* Every type of wild unit without life*/
  var enemyChicken = new WildUnitCharacter("Chicken", 3, 3, -1, -1, 1, 0)
  var enemyRoboBall = new WildUnitCharacter("RoboBall", 3, 3, -1, 1, -1, 0)
  var enemySeagull = new WildUnitCharacter("Seagull", 3, 3, 1, -1, -1, 0)
  /* List with all enemies that can be in the panel. */
  private val enemies: ArrayBuffer[WildUnitCharacter] = ArrayBuffer[WildUnitCharacter](enemyChicken, enemyRoboBall, enemySeagull)

  /** Array of the wild unit currently positioned on this panel.
   *
   * In the game, a single wild unit might be on the panel until a player defeat him.
   *
   */
  val wildUnitInPanel: ArrayBuffer[WildUnitCharacter] = new ArrayBuffer[WildUnitCharacter]()

  /** Adds a random wild unit to the list of wildUnits only if is empty.
   *
   * This might be invoked once time when a player moves to this panel to have a fight with the
   * wild unit into them.
   *
   */
  def addRandomWildUnit(): Unit = {
    if (wildUnitInPanel.isEmpty){
      val randomNumber: Random = new Random()
      val index: Int = randomNumber.nextInt(enemies.length)
      wildUnitInPanel.addOne(enemies(index))
    }

  }
  /** Remove the wild unit if him currHp is 0.
   *
   * This might be invoked every time before a duel with the player.
   *
   */
  def removeWildUnit(): Unit = {
    wildUnitInPanel(0).shouldBeDeath()
    if (wildUnitInPanel(0).death){
      wildUnitInPanel.remove(0)
    }
  }
}
