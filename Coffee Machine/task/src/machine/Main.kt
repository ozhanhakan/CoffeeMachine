package machine

fun main() {
    print("Write how many cups of coffee you will need: ")
    val needCupAmount = readln().toInt()
    // recipeCoffee(needCupAmount)
    val coffeeType = "cupOfCoffee"
    when (coffeeType) {
        "cupOfCoffee" -> cupOfCoffeRecipe(coffeeType, needCupAmount)
        else -> println("Find another solution")
    }
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