abstract class Vehicle(val make: String, val model: String, val year: Int) {

    abstract fun calculateMileage(): Double

    fun displayInfo() {
        println("Vehicle: $year $make $model")
        println("Mileage: ${calculateMileage()} miles per gallon")
    }
}

interface ElectricVehicle {
    val range: Double

    fun chargeBattery() {
        println("Charging battery...")
    }
}

open class Car(make: String, model: String, year: Int, val mileage: Double) : Vehicle(make, model, year) {

    override fun calculateMileage(): Double {
        return mileage
    }
}

class ElectricCar(make: String, model: String, year: Int, mileage: Double, override val range: Double) : Car(make, model, year, mileage), ElectricVehicle {

    override fun calculateMileage(): Double {
        return range
    }
}

fun main() {
    val car = Car("Toyota", "Corolla", 2020, 35.5)
    println("Car Information:")
    car.displayInfo()

    println()

    val electricCar = ElectricCar("Tesla", "Model 3", 2022, 0.0, 300.0)
    println("Electric Car Information:")
    electricCar.displayInfo()
    electricCar.chargeBattery()
}
