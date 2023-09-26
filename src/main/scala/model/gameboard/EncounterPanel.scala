package cl.uchile.dcc.citric
package model.gameboard

import model.units.{PlayerCharacter, WildUnitCharacter}

import scala.collection.mutable.ArrayBuffer

/** The `EncounterPanel` class represents a panel in the game.
 *
 * This class provides a list of characters who are into this panel and the panels next to them.
 * Also, this class incorporates methods to modify that list of characters, adding or removing characters depend of the
 * moment in the game.
 * For the future, this specific panel will spawn a random WildUnit until the characters defeat him.
 *
 * @author [[https://github.com/ihumire/ Ignacio Humire S.]]
 */

class EncounterPanel extends AbstractPanel {

  val wildUnits: ArrayBuffer[WildUnitCharacter] = new ArrayBuffer[WildUnitCharacter]()

  def addWildUnit(wildUnit: WildUnitCharacter): Unit = {
    wildUnits.addOne(wildUnit)
  }

  def removeWildUnit(wildUnit: WildUnitCharacter): Unit = {
    val index: Int = wildUnits.indexOf(wildUnit)
    wildUnits.remove(index)
  }

  def checkStatus(wildUnit: WildUnitCharacter): Unit = {
    wildUnit.shouldBeDeath()
    if (wildUnit.death) {
      removeWildUnit(wildUnit)
    }
  }
}
