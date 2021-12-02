/**
 * @author Dominik Birngruber
 */
fun main() {
    // Test before Day 1
    // print("Pre-Advent Test")

    // Day 1
    // finding depth increases by comparing every depth and by comparing a three depth sliding window
    var filename = "src/main/resources/Day1.txt"
    val depths = Day1.readDepths(filename)
    println("--- Day 1 ------------------------------")
    println("Number of increases for depth: " + Day1.findNumIncreases(depths))
    println("Number of increases for depth windows: " + Day1.findNumIncreasedWindow(depths))

    //Day 2
    // exectuing the given commands for the submarine
    filename = "src/main/resources/Day2.txt"
    val commands = Day2.readDirections(filename)
    println()
    println("--- Day 2 ------------------------------")
    println("Multiple of horizontal and vertical after executing commands: " + Day2.executeCommands(commands))
    println("Multiple of horizontal and vertical after using aim and executing commands: "
            + Day2.executeCommandsByAim(commands))

    //@ToDo Day 3

    //@ToDo Day 4

    //@ToDo Day 5

    //@ToDo Day 6

    //@ToDo Day 7

    //@ToDo Day 8

    //@ToDo Day 9

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