/**
 * @author Dominik Birngruber
 */
fun main() {
    // Test before Day 1
    // print("Pre-Advent Test")

    // Day 1
    // finding depth increases by comparing every depth and by comparing a three depth sliding window
    val depths = Day1.readDepths("src/main/resources/Day1.txt")
    println("--- Day 1 ------------------------------")
    println("Number of increases for depth: " + Day1.findNumIncreases(depths))
    println("Number of increases for depth windows: " + Day1.findNumIncreasedWindow(depths))

    // Day 2
    // executing the given commands for the submarine
    val commands = Day2.readDirections("src/main/resources/Day2.txt")
    println()
    println("--- Day 2 ------------------------------")
    println("Multiple of horizontal and vertical after executing commands: " + Day2.executeCommands(commands))
    println("Multiple of horizontal and vertical after using aim and executing commands: "
            + Day2.executeCommandsByAim(commands))

    // Day 3
    // checking the maintenance data from the submarine
    val binaryData = Day3.readBinaryData("src/main/resources/Day3.txt")
    println()
    println("--- Day 3 ------------------------------")
    println("Power consumption: " + Day3.calculateConsumption(binaryData))
    println("life support rating: " + Day3.findLifeSupportRating(binaryData))

    // Day 4
    // winning or losing bingo against a squid
    var bingoGame = Day4.readGameInput("src/main/resources/Day4.txt")
    println()
    println("--- Day 4 ------------------------------")
    println("Score of winning board: " + Day4.solveBingoGame(bingoGame))
    bingoGame = Day4.readGameInput("src/main/resources/Day4.txt")
    println("Score of losing board: " + Day4.findLosingGame(bingoGame))

    // Day 5
    // finding dangerous vent zones
    val segments = Day5.readSegments("src/main/resources/Day5.txt")
    println()
    println("--- Day 5 ------------------------------")
    println("Number of dangerous zones with vertical and horizontal vent lines: " + Day5.findDangerZonesHorVer(segments))
    println("Number of dangerous zones with all vent lines: " + Day5.findAllDangerZones(segments))

    // Day 6
    // Fining the number of angler-fish after a given time
    val startPopulation = Day6.readPopulation("src/main/resources/Day6.txt")
    println()
    println("--- Day 6 ------------------------------")
    println("Population after 80 days: " + Day6.calculatePopulation80Days(startPopulation))
    println("Population after 256 days: " + Day6.calculatePopulation256Days(startPopulation))

    // Day 7
    val positions = Day7.readPositions("src/main/resources/Day7.txt")
    println()
    println("--- Day 7 ------------------------------")
    println("Fuel cost linear: " + Day7.alignCrabsLinear(positions))
    println("Final fuel cost: " + Day7.alignCrabs(positions))

    // Day 8
    val entries = Day8.readEntries("src/main/resources/Day8.txt")
    println()
    println("--- Day 8 ------------------------------")
    println("Easy digits found: " + Day8.findEasyDigits(entries))
    println("Sum of all digits: " + "Could not finish part 2")

    // Day 9
    var system = Day9.readCaveSystem("src/main/resources/Day9.txt")
    println()
    println("--- Day 9 ------------------------------")
    println("Risk level of the cave system: " + Day9.calculateRiskLevel(system))
    println("Multiple of basin sizes: " + "Could not finish part 2")

    //@ToDo Day 10

    //@ToDo Day 11

    //@ToDo Day 12

    //@ToDo Day 13

    //@ToDo Day 14

    //@ToDo Day 15

    //@ToDo Day 16

    //@ToDo Day 17

    //@ToDo Day 18

    //@ToDo Day 19

    //@ToDo Day 20

    //@ToDo Day 21

    //@ToDo Day 22

    //@ToDo Day 23

    //@ToDo Day 24

    //@ToDo Day 25
}