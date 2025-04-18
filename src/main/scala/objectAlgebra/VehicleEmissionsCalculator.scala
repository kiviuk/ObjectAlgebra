package mobe
package objectAlgebra

import objectAlgebra.car.{EmissionsVehicleAlg, VehicleAlg}

class VehicleEmissionsCalculator(fuelCalculator: VehicleAlg[FuelConsumption])
  extends EmissionsVehicleAlg[FuelConsumption]:

  override def drive(kiloMeters: Int): FuelConsumption =
    fuelCalculator.drive(kiloMeters)

  override def calculateEmissions(kiloMeters: Int): Emissions =
    val fuelUsed = this.drive(kiloMeters).litersUsed
    new Emissions:
      def co2Grams: Double = fuelUsed * 2300 // 2.3kg CO2 per liter of fuel
