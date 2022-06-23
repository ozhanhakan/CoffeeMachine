package machine

fun main() {
    val cofMac = CoffeeMachine()
    cofMac.menu()
}

class CoffeeMachine {
    var reserveWater = 400 // getReserveWaterFromUser()
    var reserveMilk = 540// getReserveMilkFromUser()
    var reserveCoffeeBean = 120//getReserveCoffeeBeanFromUser()
    var hasMoney = 550
    var reserveDisposableCups = 9
//    var userInput = ""
//    var action = Action.MENU
    fun getInput(): String {
        return readln()
    }

    fun setMachine() {
        print("Write how many ml of water do you want to add: ")
        reserveWater += readln().toInt()
        print("Write how many ml of milk do you want to add: ")
        reserveMilk += readln().toInt()
        print("Write how many grams of coffee beans do you want to add: ")
        reserveCoffeeBean += readln().toInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        reserveDisposableCups += readln().toInt()
    }

    fun takeMoney() {
        println("I gave you $$hasMoney")
        hasMoney = 0
    }

    fun getCoffeeMachineInfo() {
        println(
            """
        The coffee machine has:
        $reserveWater ml of water
        $reserveMilk ml of milk
        $reserveCoffeeBean g of coffee beans
        $reserveDisposableCups disposable cups
        $${hasMoney} of money
    """.trimIndent()
        )
    }

    fun menu() {
        while (true) {
            print("Write action (buy, fill, take, remaining, exit): ")
            val action = getInput().uppercase()
            println()
            when (action) {
                Action.BUY.toString() -> buyMenu()
                Action.FILL.toString() -> setMachine()
                Action.TAKE.toString() -> takeMoney()
                Action.REMAINING.toString() -> getCoffeeMachineInfo()
                Action.EXIT.toString() -> return
            }
        }
    }

    fun buyMenu() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        val input = getInput()
        if (input == "back" || input.isBlank()) return
        val coffeeType = Coffee.values()[input.toInt().dec()]
       // Coffee.values()[coffeeType.toInt().dec()].milk
        val notEnough = controlReserve(coffeeType)
        if (notEnough == "") {
            println("I have enough resources, making you a coffee!")
            reserveWater -= coffeeType.water
            reserveMilk -= coffeeType.milk
            reserveCoffeeBean -= coffeeType.bean
            reserveDisposableCups -= 1
            hasMoney += coffeeType.cost
        } else println("Sorry, not enough $notEnough!")
    }

    fun controlReserve(coffeeType: Coffee): String {
        var notEnough = ""
        if (coffeeType.water > reserveWater) notEnough += "water"
        if (coffeeType.milk > reserveMilk
        ) notEnough += if (notEnough == "") "milk" else ", milk"
        if (coffeeType.bean > reserveCoffeeBean
        ) notEnough += if (notEnough == "") "coffee beans" else ", coffee beans"
// Coffee.values()[coffeeType.toInt().dec()].milk
        return notEnough
    }
}

enum class Coffee(val water: Int, val milk: Int, val bean: Int, val cost: Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCINO(200, 100, 12, 6);
}

enum class Action {
    BUY,
    FILL,
    TAKE,
    REMAINING,
    EXIT
}