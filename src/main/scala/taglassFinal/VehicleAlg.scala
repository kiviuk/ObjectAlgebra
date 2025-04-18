package mobe
package taglassFinal

trait VehicleAlg[E] {
  def drive(kiloMeters: Int): E
}


case class CaloriesConsumption(caloriesUsed: Double)
case class FuelConsumption(litersUsed: Double)


given VehicleAlg[CaloriesConsumption] with
  def drive(kiloMeters: Int): CaloriesConsumption =
    CaloriesConsumption(kiloMeters * 10)

given VehicleAlg[FuelConsumption] with
  def drive(kiloMeters: Int): FuelConsumption =
    FuelConsumption(kiloMeters * 7)


type CustomVehicle[E] = Double => VehicleAlg[E]

given CustomVehicle[FuelConsumption] with
  def apply(litersPerKilometer: Double): VehicleAlg[FuelConsumption] = new VehicleAlg[FuelConsumption]:
    def drive(kiloMeters: Int): FuelConsumption =
      FuelConsumption(kiloMeters * litersPerKilometer)
