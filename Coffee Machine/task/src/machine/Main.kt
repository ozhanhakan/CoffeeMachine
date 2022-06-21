package machine

fun main() {
    // setup coffee machine reserve
    println()
    // stage 4/6 init

    var reserveWater = 400 // getReserveWaterFromUser()
    var reserveMilk = 540// getReserveMilkFromUser()
    var reserveCoffeeBean = 120//getReserveCoffeeBeanFromUser()
    var hasMoney = 550
    var reserveDisposableCups = 9

    val espressoWater = 250
    val espressoBeans = 16
    val espressoMoney = 4
    val latteWater = 350
    val latteMilk = 75
    val latteBeans = 20
    val latteMoney = 7
    val cappucinoWater = 200
    val cappucinoMilk = 100
    val cappucinoBeans = 12
    val cappucinoMoney = 6

    // Menu
    // getCoffeeMachineInfo(reserveWater, reserveMilk, reserveCoffeeBean, reserveDisposableCups, hasMoney)

    while (true) {
        println()
        print("Write action (buy, fill, take, remaining, exit): ")
        val action = readln()
        println()
        when (action) {
            "buy" -> {
                when (buyMenu()) {
                    "1" -> {
                        val notEnough = controlReserve("1", reserveWater, reserveMilk, reserveCoffeeBean)
                        if (notEnough == "") {
                            println("I have enough resources, making you a coffee!")
                            reserveWater -= espressoWater
                            reserveCoffeeBean -= espressoBeans
                            reserveDisposableCups -= 1
                            hasMoney += espressoMoney
                        } else println("Sorry, not enough $notEnough!")
                    }
                    "2" -> {
                        val notEnough = controlReserve("2", reserveWater, reserveMilk, reserveCoffeeBean)
                        if (notEnough == "") {
                            println("I have enough resources, making you a coffee!")
                            reserveWater -= latteWater
                            reserveMilk -= latteMilk
                            reserveCoffeeBean -= latteBeans
                            reserveDisposableCups -= 1
                            hasMoney += latteMoney
                        } else println("Sorry, not enough $notEnough!")
                    }
                    "3" -> {
                        val notEnough = controlReserve("3", reserveWater, reserveMilk, reserveCoffeeBean)
                        if (notEnough == "") {
                            println("I have enough resources, making you a coffee!")
                            reserveWater -= cappucinoWater
                            reserveMilk -= cappucinoMilk
                            reserveCoffeeBean -= cappucinoBeans
                            reserveDisposableCups -= 1
                            hasMoney += cappucinoMoney
                        } else println("Sorry, not enough $notEnough!")
                    }
                    "back" -> continue
                }
                //getCoffeeMachineInfo(reserveWater, reserveMilk, reserveCoffeeBean, reserveDisposableCups, hasMoney)

            }
            "fill" -> {
                print("Write how many ml of water do you want to add: ")
                reserveWater += readln().toInt()
                print("Write how many ml of milk do you want to add: ")
                reserveMilk += readln().toInt()
                print("Write how many grams of coffee beans do you want to add: ")
                reserveCoffeeBean += readln().toInt()
                print("Write how many disposable cups of coffee do you want to add: ")
                reserveDisposableCups += readln().toInt()
                //getCoffeeMachineInfo(reserveWater, reserveMilk, reserveCoffeeBean, reserveDisposableCups, hasMoney)
            }
            "take" -> {
                println("I gave you $$hasMoney")
                hasMoney = 0
            }
            "remaining" -> getCoffeeMachineInfo(
                reserveWater,
                reserveMilk,
                reserveCoffeeBean,
                reserveDisposableCups,
                hasMoney
            )
            "exit" -> return
        }
    }

}

fun buyMenu(): String {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val menu = readln()
    return when (menu) {
        "1" -> "1"
        "2" -> "2"
        "3" -> "3"
        "back" -> "back"
        else -> "back"
    }
}

fun getCoffeeMachineInfo(
    reserveWater: Int,
    reserveMilk: Int,
    reserveCoffeeBean: Int,
    reserveDisposableCups: Int,
    hasMoney: Int
) {
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

fun controlReserve(coffeeType: String, reserveWater: Int, reserveMilk: Int, reserveCoffeeBean: Int): String {
    val espressoWater = 250
    val espressoBeans = 16

    val latteWater = 350
    val latteMilk = 75
    val latteBeans = 20

    val cappucinoWater = 200
    val cappucinoMilk = 100
    val cappucinoBeans = 12

    /*var possibleWater = reserveWater
    var possibleMilk = reserveMilk
    var possibleCoffeeBean = reserveCoffeeBean
    val possibleAmount = minOf(possibleMilk, possibleWater, possibleCoffeeBean)*/
    var notEnough = ""
    when (coffeeType) {
        "1" -> {
            if (espressoWater > reserveWater) notEnough = "water"
            if (espressoBeans > reserveCoffeeBean) notEnough = "coffee beans"
        }
        "2" -> {
            if (latteWater > reserveWater) notEnough = "water"
            if (latteMilk > reserveMilk) notEnough = "milk"
            if (latteBeans > reserveCoffeeBean) notEnough = "coffee beans"
        }
        "3" -> {
            if (cappucinoWater > reserveWater) notEnough = "water"
            if (cappucinoMilk > reserveMilk) notEnough = "milk"
            if (cappucinoBeans > reserveCoffeeBean) notEnough = "coffee beans"
        }
    }
    return notEnough
}

fun getReserveCoffeeBeanFromUser(): Int {
    return readln().toInt()
}

fun getReserveMilkFromUser(): Int {
    return readln().toInt()
}

fun getReserveWaterFromUser(): Int {
    return readln().toInt()
}

fun cupOfCoffeRecipe(coffeeType: String, needCupAmount: Int) {
    val water200ml = 200
    val milk50ml = 50
    val coffeeBean15gr = 15
    val oneCupOfCoffe = water200ml + milk50ml + coffeeBean15gr
    println(
        """
        For $needCupAmount cups of coffee you will need:
        ${needCupAmount * water200ml} ml of water
        ${needCupAmount * milk50ml} ml of milk
        ${needCupAmount * coffeeBean15gr} g of coffee beans
    """.trimIndent()
    )
}

class CoffeeMachine() {

}

class Coffee(water: Int, milk: Int, bean: Int, cost: Int) {

}

class User() {

}