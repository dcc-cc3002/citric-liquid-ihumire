package cl.uchile.dcc.citric
package model.gameboard

import model.units.{PlayerCharacter, WildUnitCharacter}

import scala.collection.mutable.ArrayBuffer

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
  private var enemyChicken = new WildUnitCharacter("Chicken",3,0,-1,-1,1,0)
  private var enemyRoboBall = new WildUnitCharacter("RoboBall",3,0,-1,1,-1,0)
  private var enemySeagull = new WildUnitCharacter("Seagull",3,0,1,-1,-1,0)
  /** Array of all the possibles wild units who can be on this panel.
   */
  val allWildUnits: ArrayBuffer[WildUnitCharacter] = ArrayBuffer[WildUnitCharacter](enemyChicken,enemyRoboBall,enemySeagull)
  /** Array of the wild unit currently positioned on this panel.
   *
   * In the game, a single wild unit might be on the panel until a player defeat him.
   *
   */
  val wildUnits: ArrayBuffer[WildUnitCharacter] = new ArrayBuffer[WildUnitCharacter]()

  /** Adds a wild unit to the list of wildUnits currently on this panel.
   *
   * This might be invoked once time when a player moves to this panel to have a fight with the
   * wild unit into them. A random wild unit will spawn in the panel if wildsUnits is empty.
   *
   * @param wildUnit The wild unit to add to this panel.
   */
  def addWildUnit(wildUnit: WildUnitCharacter): Unit = {
    wildUnits.addOne(wildUnit)
  }
  /** Remove a wild unit to the list of wildUnits currently on this panel.
   *
   * This might be invoked once time when a player defeat the wild unit or the turn ends.
   *
   * @param wildUnit The wild unit to remove from this panel.
   */
  def removeWildUnit(wildUnit: WildUnitCharacter): Unit = {
    val index: Int = wildUnits.indexOf(wildUnit)
    wildUnits.remove(index)
  }

  /** Checks if the wild unit is alive.
   *
   * If is death, it will be removed.
   *
   * @param wildUnit The wild unit to check.
   */
  def checkStatus(wildUnit: WildUnitCharacter): Unit = {
    wildUnit.shouldBeDeath()
    if (wildUnit.death) {
      removeWildUnit(wildUnit)
    }
  }
}
