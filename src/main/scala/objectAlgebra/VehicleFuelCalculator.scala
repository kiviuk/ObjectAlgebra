package mobe
package objectAlgebra

import car.VehicleAlg


class VehicleFuelCalculator(litersPerKilometer: Double) extends VehicleAlg[FuelConsumption]:
  override def drive(kiloMeters: Int): FuelConsumption =
    new FuelConsumption:
      def litersUsed: Double = kiloMeters * litersPerKilometer
