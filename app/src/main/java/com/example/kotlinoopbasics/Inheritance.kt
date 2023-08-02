package com.example.kotlinoopbasics

import kotlinx.coroutines.channels.BufferOverflow
import java.time.temporal.TemporalAmount

// interface
interface Drivable {
    val maxSpeed: Double
    fun drive(): String
    fun brake() {
        println("The drivable is braking")
    }
}

// Super Class, Patrent Class, Base Class of Vehicle
open class Car(override val maxSpeed: Double, val name: String, val brand: String) : Drivable {
    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if (amount > 0) {
            range += amount
        }
    }

    override fun drive(): String {
        return "Driven with interface"
    }

    open fun drive(distance: Double) {
        println("Drove for $distance KM")
    }
}

// sub Class Child class or Derived class of car
class ElectricCar(maxSpeed: Double, name: String, brand: String, batteryLife: Double) :
    Car(maxSpeed, name, brand) {

    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        println("Drove for $distance KM on electricity")
    }

    override fun drive(): String {
        return "Driveng with interface123"
    }

    override fun brake() {
        super.brake()
        println("brake insede of electric car")
    }

}

fun main() {
    var audiA3 = Car(200.00, "A3", "Audi")
    var teslaS = ElectricCar(200.00, "S-Model", "Tesla", 100.0)

    teslaS.extendRange(200.0)

    // on log
    teslaS.drive()
    teslaS.brake()
    audiA3.brake()

    // Polymorphism
    audiA3.drive(200.0)
    teslaS.drive(200.0)
}