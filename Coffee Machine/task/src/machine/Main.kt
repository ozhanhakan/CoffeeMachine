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
    getCoffeeMachineInfo(reserveWater, reserveMilk, reserveCoffeeBean, reserveDisposableCups, hasMoney)
    println()
    print("Write action (buy, fill, take): ")
    var action = readln()
    when (action) {
        "buy" -> {
            when (buyMenu()) {
                1 -> {
                    reserveWater -= espressoWater
                    reserveCoffeeBean -= espressoBeans
                    reserveDisposableCups -= 1
                    hasMoney += espressoMoney
                }
                2 -> {
                    reserveWater -= latteWater
                    reserveMilk -= latteMilk
                    reserveCoffeeBean -= latteBeans
                    reserveDisposableCups -= 1
                    hasMoney += latteMoney
                }
                3 -> {
                    reserveWater -= cappucinoWater
                    reserveMilk -= cappucinoMilk
                    reserveCoffeeBean -= cappucinoBeans
                    reserveDisposableCups -= 1
                    hasMoney += cappucinoMoney
                }
            }

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
        }
        "take" -> {
            println("I gave you $$hasMoney")
            hasMoney = 0
        }
    }

    getCoffeeMachineInfo(reserveWater, reserveMilk, reserveCoffeeBean, reserveDisposableCups, hasMoney)

}

fun buyMenu(): Int {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    return readln().toInt()
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

fun controlReserve(needCupAmount: Int, reserveWater: Int, reserveMilk: Int, reserveCoffeeBean: Int) {
    val water200ml = 200
    val milk50ml = 50
    val coffeeBean15gr = 15
    val possibleWater = reserveWater / water200ml
    val possibleMilk = reserveMilk / milk50ml
    val possibleCoffeeBean = reserveCoffeeBean / coffeeBean15gr
    val possibleAmount = minOf(possibleMilk, possibleWater, possibleCoffeeBean)
    //val possibleMore=needCupAmount-possibleAmount
    // val oneCupOfCoffe = water200ml + milk50ml + coffeeBean15gr
    when {
        possibleAmount >= 1 + needCupAmount -> println("Yes, I can make that amount of coffee (and even ${possibleAmount - needCupAmount} more than that)")
        possibleAmount >= needCupAmount -> println("Yes, I can make that amount of coffee")
        else -> println("No, I can make only $possibleAmount cups of coffee")
    }
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