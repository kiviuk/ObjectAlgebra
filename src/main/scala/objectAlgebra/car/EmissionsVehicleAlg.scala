package mobe
package objectAlgebra.car

import objectAlgebra.Emissions

trait EmissionsVehicleAlg[E] extends VehicleAlg[E]:
  def calculateEmissions(kiloMeters: Int): Emissions
