fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val locations = readLocationInfo()

    var loc = 64

    while (true) {
        val location = locations[loc] ?: Location(0,
        "Sorry, something went wrong, so the game will terminate")

        println(location.description)

        if (location.locationID == 0) {
            break
        }

        print("Available exits are: ")

        location.exits.keys.forEach {
            print("$it, ")
        }

        val direction = readLine()?.toUpperCase() ?: "Z"

        if (location.exits.containsKey(direction)) {
            loc = location.exits[direction]!!
        } else {
            println("You can't go in that direction")
        }
    }
}
