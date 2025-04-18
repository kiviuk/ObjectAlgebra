package mobe
package objectAlgebra

import objectAlgebra.car.{EmissionsVehicleAlg, VehicleAlg}

// In object algebra pattern, handling multiple carrier types (like FuelConsumption and Emissions)
// can be challenging. When different operations return different types, we need to create separate algebras or use
// complex type parameters, which can lead to increased complexity and reduced composability of the interpreters.
class VehicleEmissionsCalculator(fuelCalculator: VehicleAlg[FuelConsumption])
  extends EmissionsVehicleAlg[FuelConsumption]:

  override def drive(kiloMeters: Int): FuelConsumption =
    fuelCalculator.drive(kiloMeters)

  override def calculateEmissions(kiloMeters: Int): Emissions =
    val litersUsed = this.drive(kiloMeters).litersUsed
    new Emissions:
      def co2Grams: Double = litersUsed * 2300 // 2.3kg CO2 per liter of fuel

