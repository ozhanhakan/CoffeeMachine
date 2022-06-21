package machine

fun main() {
    // setup coffee machine reserve
    println()
    print("Write how many ml of water the coffee machine has: ")
    var reserveWater = getReserveWaterFromUser()
    print("Write how many ml of milk the coffee machine has: ")
    var reserveMilk = getReserveMilkFromUser()
    print("Write how many grams of coffee beans the coffee machine has: ")
    var reserveCoffeeBean = getReserveCoffeeBeanFromUser()
    print("Write how many cups of coffee you will need: ")
    val needCupAmount = readln().toInt()

    // Control reserve
    controlReserve(needCupAmount, reserveWater, reserveMilk, reserveCoffeeBean)
    // recipeCoffee(needCupAmount)
    /*val coffeeType = "cupOfCoffee"
    when (coffeeType) {
        "cupOfCoffee" -> cupOfCoffeRecipe(coffeeType, needCupAmount)
        else -> println("Find another solution")
    }*/
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