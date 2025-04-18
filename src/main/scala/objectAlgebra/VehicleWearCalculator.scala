package mobe
package objectAlgebra

import car.VehicleAlg


class VehicleWearCalculator extends VehicleAlg[Maintenance]:
  override def drive(kiloMeters: Int): Maintenance =
    new Maintenance:
      def wearAndTear: Double = kiloMeters * 0.01 // 1% wear per 100km