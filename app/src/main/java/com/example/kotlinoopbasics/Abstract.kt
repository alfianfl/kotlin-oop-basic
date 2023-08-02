package com.example.kotlinoopbasics

// However, you can inherit subclasses fron an abstract class
// The members (properties and methods) of an abstract class are non-abstract
// unless you explicitiy use the abstact: keyword to make them abstract
abstract class Mammal(
    private val name: String, private val origin: String,
    private val weight: Double
) {

    // Abstract property (Must be overridden by Subclasses)
    abstract var maxSpeed: Double

    // Abstract Methods (Must be implemented by Subclasses)
    abstract fun run()
    abstract fun breath()

    fun displayDetails() {
        println("Name: $name, Origin: $origin, Weight: $weight" + " Max Speed: $maxSpeed")
    }
}

class Human(
    name: String, origin: String, weight: Double,
    override var maxSpeed: Double
) : Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Run on two legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through mouth or nose")
    }
}

class Elephant(
    name: String, origin: String, weight: Double,
    override var maxSpeed: Double
) : Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Run on four legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through trunk")
    }
}

fun main(){
    val human = Human("dennis", "russia", 70.00, 28.00)
    val elephant = Elephant("Rosy", "India", 540.00, 25.00)

    human.run()
    elephant.run()

    human.breath()
    elephant.breath()
}
