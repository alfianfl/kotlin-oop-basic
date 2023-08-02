fun main() {

    // create an object like so:
    val denis = Person("Denis", "Panjuta")
    val denis2 = Person2("Denis2", "Panjuta2")
    val person5 = Person5("Denis5", "Panjuta5", 24)
    person5.stateHobby()

    var car2 = Car2()
    val iphone = MobilePhone("iOS", "Apple", "iPhone 12")
    val galaxyS20 = MobilePhone("Android", "Samsung", "Galaxy S20")
    val mateXS = MobilePhone("Android", "Huawei", "Mate X S")

    iphone.chargeBattery(70)


    /*
    val john = Person4()
    val johnPeterson = Person4(lastname: "Peterson")
    */

    // Exercise 1
    //    var samsung = MobilePhone("Android", "Samsung", "Galaxy S20 Ultra")
    //    val galaxyS20 = MobilePhone("Android","Samsung", "Galaxy S20")
    //    val mateXS = MobilePhone("Android", "Huawei", "Mate X S")
}

class Person constructor(_firstName: String, _lastName: String) {
    // Member Variables (Properties) of the class
    var firstName: String
    var lastName: String

    init {
        this.firstName = _firstName
        this.lastName = _lastName

        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
    }
}

// Alternatively:
class Person2(_firstName: String, _lastName: String) {
    // Member Variables (Properties) of the class
    var firstName: String = _firstName
    var lastName: String = _lastName

    // Initializer Block
    init {
        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
    }
}

// Alternatively:
class Person3(var firstName: String, var lastName: String) {
    // Initializer Block
    init {
        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
    }
}

// Or even:
// whereby John and Doe will be default values
class Person4(var firstName: String = "John", var lastName: String = "Doe") {
    // Initializer Block
    init {
        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
    }
}

// secondary constructor example

class Person5(firstName: String, lastName: String) {
    var age: Int = 25
    var hobby: String = "Watch Netflix"
    var firstName: String = firstName

    init {
        println("$firstName is $age years old")
    }

    // secondary constructor
    constructor(firstName: String, lastName: String, age: Int) :
            this(firstName, lastName) {
        this.age =
            if (age > 0) age else throw IllegalArgumentException("Age must be greater than zero")
        println("$firstName is $age years old")
    }

    fun stateHobby() {
        println("${firstName} \'s Hobby is: $hobby'")
    }
}

// SETTERS AND GETTERS

// User class with a Primary constructor that accepts
// three parameters

//class Car(_brand: String, _model: String, _maxSpeed: Int) {
//    // Properties of User class
//
//    val brand: String = _brand         // Immutable (Read only)
//    var model: String = _model  // Mutable
//    var maxSpeed: Int = _maxSpeed       // Mutabl
//}

// Kotlin internally generates a default getter and setter for mutable properties, and a getter (only) for read-only properties.

// It calls these getters and setters internally whenever
// you access or modify a property using the dot(.) notation.
// This is how it would look like internally

class Car(_brand: String, _model: String, _maxSpeed: Int) {
    val brand: String = _brand
        get() = field

    var model: String = _model
        get() = field
        set(value) {
            field = value
        }

    var maxSpeed: Int = _maxSpeed
        get() = field
        set(value) {
            field = value
        }
}

// value
// We use value as the name of the setter parameter. This is the default convention in Kotlin but you’re free to use any other name if you want.
// The value parameter contains the value that a property is assigned to. For example, when you write user.name = "Elon Musk",
// the value parameter contains the assigned value "Elon Musk".

// 2. Backing Field (field)
// Backing field helps you refer to the property
// inside the getter and setter methods.
// This is required because if you use the property
// directly inside the getter or setter then you’ll
// run into a recursive call which will generate
// a StackOverflowError.

class Car2() {
    lateinit var owner: String

    var myBrand: String = "BMW"
        // Custom getter
        get() {
            return field.toLowerCase()
        }

    // default setter and getter
    var myModel: String = "M5"
        private set

    var myMaxSpeed: Int = 20
        get() = field
        // costum setter
        set(value) {
            field =
                if (value > 0) value else throw IllegalArgumentException("_maxSpeed must be greater than zero")
        }

    init {
        this.myModel = "M3"
        this.owner = "frank"
    }
}


// Exercise 1
//class MobilePhone(osName:String, brand:String, model:String) {
//    init {
//        print("; $osName $brand $model")
//    }
//}

// Exercise 2
//fun main(){
//    val iphone = MobilePhone("iOS", "Apple", "iPhone 12")
//    val galaxyS20 = MobilePhone("Android","Samsung", "Galaxy S20")
//    val mateXS = MobilePhone("Android", "Huawei", "Mate X S")
//}
//
class MobilePhone(osName: String, brand: String, model: String) {

    private var battery = 30

    init {
        println("The phone $model from $brand uses $osName as its Operating System")
    }

    fun chargeBattery(chargedBy: Int) {
        println("Battery was at $battery and is at ${battery + chargedBy} now")
        battery += chargedBy
    }
}