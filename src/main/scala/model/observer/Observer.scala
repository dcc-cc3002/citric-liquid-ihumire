package cl.uchile.dcc.citric
package model.observer

import model.observable.Subject

/**
 * A trait representing an observer in the observer pattern.
 *
 * Observers are entities that are notified by subjects about changes.
 * The `update` method is called when the observed subject changes its state.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 *
 */
trait Observer {
  /**
   * This method is called by the observed subject when its state changes.
   *
   * @param observable The subject that changed its state.
   * @param value      The value associated with the change.
   */
  def update(observable: Subject, value: Any): Unit
}
