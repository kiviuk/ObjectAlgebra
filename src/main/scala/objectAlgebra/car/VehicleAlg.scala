package mobe
package objectAlgebra.car

trait VehicleAlg[E]:
  def drive(kiloMeters: Int): E
