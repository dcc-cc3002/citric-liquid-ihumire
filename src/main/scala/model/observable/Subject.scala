package cl.uchile.dcc.citric
package model.observable

import model.observer.Observer

trait Subject {
  def addObserver(observer: Observer): Unit
  def notifyObservers(value: Any): Unit
}
