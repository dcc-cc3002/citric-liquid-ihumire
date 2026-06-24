package cl.uchile.dcc.citric
package model.observable

import model.observer.Observer

/**
 * A trait representing the subject in the observer pattern.
 *
 * The subject maintains a list of observers and provides methods to
 * add observers and notify them of changes.
 *
 * @author [[https://github.com/ihumire Ignacio Humire S.]]
 *
 */
trait Subject {
  /**
   * Adds an observer to the list of observers.
   *
   * @param observer The observer to be added.
   */
  def addObserver(observer: Observer): Unit

  /**
   * Notifies all registered observers with a specific value.
   *
   * @param value The value to be passed to observers during the notification.
   */
  def notifyObservers(value: Any): Unit
}
