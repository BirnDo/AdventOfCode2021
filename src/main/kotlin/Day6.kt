import java.io.File

/**
 * @author Dominik Birngruber
 */
class Day6 {
    companion object {
        /**
         * reads the population data from a given file
         * @param filename the file containing the population data
         * @return a list of fish as Integers referencing the time to reproduce
         */
        fun readPopulation(filename: String): List<Int> = File(filename).readText().split(",").map { it.toInt() }

        /**
         * calculates the population of fish after 80 days
         * @param startPop the list of starting fish
         * @return the number of fish after 80 days
         */
        fun calculatePopulation80Days(startPop: List<Int>): Long {
            // count the number of fish with a given time to reproduce
            var fish = MutableList(9) { i -> startPop.count { it == i }.toLong() }

            repeat(80) {
                // find all fish that will reproduce this day
                val fishToReproduce = fish[0]
                // remove the fish that reproduce, all other fish go one index down
                fish = fish.drop(1).toMutableList()
                // add the fish that reproduced back to the 6-day timer
                fish[6] += fishToReproduce
                // add the offspring at the end (timer of 8 days)
                fish.add(fishToReproduce)
            }

            return fish.sum()
        }

        /**
         * calculates the population of fish after 256 days
         * The same as its 80-day counterpart, but split up for readability
         * @param startPop the list of starting fish
         * @return the number of fish after 256 days
         */
        fun calculatePopulation256Days(startPop: List<Int>): Long {
            var fish = MutableList(9) { i -> startPop.count { it == i }.toLong() }

            repeat(256) {
                val fishToReproduce = fish[0]
                fish = fish.drop(1).toMutableList()
                fish[6] += fishToReproduce
                fish.add(fishToReproduce)
            }

            return fish.sum()
        }
    }
}