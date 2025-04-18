package mobe
package objectAlgebra

import car.VehicleAlg


class VehicleOdometer extends VehicleAlg[Distance]:
  override def drive(kiloMeters: Int): Distance =
    new Distance:
      def kilometers: Int = kiloMeters
