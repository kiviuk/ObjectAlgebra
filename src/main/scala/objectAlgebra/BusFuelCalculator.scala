package mobe
package objectAlgebra

import bus.BusAlg
import car.VehicleAlg

class BusFuelCalculator(vehicleFuelCalculator: VehicleAlg[FuelConsumption]) extends BusAlg[FuelConsumption]{
  private var passengers: Int = 0

  def loadPassengers(count: Int): Unit =
    passengers += count

  def unloadPassengers(count: Int): Unit =
    val actualCount = Math.min(count, passengers)
    passengers -= actualCount

  def getPassengerCount: Int = passengers

  override def drive(kiloMeters: Int): FuelConsumption =
    val baseConsumption: Double =  vehicleFuelCalculator.drive(kiloMeters).litersUsed
    new FuelConsumption:
      def litersUsed: Double = baseConsumption * 1.15 + passengers * 0.01
}
