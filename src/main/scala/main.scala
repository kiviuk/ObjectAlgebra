package mobe

import objectAlgebra.{BusFuelCalculator, VehicleEmissionsCalculator, VehicleFuelCalculator}

import mobe.taglassFinal.{CaloriesConsumption, CustomVehicle, FuelConsumption, VehicleAlg, given_VehicleAlg_CaloriesConsumption, given_VehicleAlg_FuelConsumption}
import mobe.taglassFinal.given_CustomVehicle_FuelConsumption

object ObjectAlgebra {

  def demo(): Unit =
    println("Object Algebra example")

    // Car example
    println("General vehicle example:")
    val vehicleFuelCalculator = new VehicleFuelCalculator(8.0)

    val vehicleWithEmissions = new VehicleEmissionsCalculator(vehicleFuelCalculator)

    // Use new behavior
    val emissions = vehicleWithEmissions.calculateEmissions(100).co2Grams
    println(s"Vehicle emitted $emissions grams of CO2")

    // Bus example
    println("\nBus example:")
    val busFuelCalculator = new BusFuelCalculator(vehicleFuelCalculator)

    // Load passengers
    busFuelCalculator.loadPassengers(20)

    // Drive with passengers
    val busFuelConsumption = busFuelCalculator.drive(100)
    println(s"Bus drove 100km with 20 passengers and used ${busFuelConsumption.litersUsed} liters of fuel")

    // Unload passengers
    busFuelCalculator.unloadPassengers(20)

    // Drive without passengers
    val emptyBusFuelConsumption = busFuelCalculator.drive(100)
    println(s"Bus drove 100km without passengers and used ${emptyBusFuelConsumption.litersUsed} liters of fuel")

}

object TaglessFinal {
  def demo(): Unit = {
    println("Tagless final example")

    val caloriesConsumption: CaloriesConsumption = summon[VehicleAlg[CaloriesConsumption]].drive(100)

    println(s"Used ${caloriesConsumption.caloriesUsed} calories")

    val fuelConsumption: FuelConsumption = summon[VehicleAlg[FuelConsumption]].drive(100)

    println(s"Used ${fuelConsumption.litersUsed} liters of fuel")

    val customVehicle = summon[CustomVehicle[FuelConsumption]](litersPerKilometer=10.0)

    println(s"Custom vehicle used ${customVehicle.drive(100).litersUsed} liters of fuel")


  }


}

@main
def main(): Unit =
  ObjectAlgebra.demo()
  TaglessFinal.demo()

