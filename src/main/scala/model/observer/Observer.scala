package cl.uchile.dcc.citric
package model.observer

import model.observable.Subject

trait Observer {
  def update(observable: Subject, value: Any): Unit
}
