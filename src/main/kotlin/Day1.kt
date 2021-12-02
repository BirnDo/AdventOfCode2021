/**
 * @author Dominik Birngruber
 */
import java.io.File

class Day1 {
    companion object {
        /**
         * Reads all depths of a given file, where each line has a single Integer for the depth
         * @param filename Name of the file to read
         * @return List of depths
         */
        fun readDepths(filename: String): List<Int> {
            val values = mutableListOf<Int>()
            File(filename).readLines().forEach { values.add(it.toInt()) }
            return values
        }

        /**
         * Finds the number of depth increases
         * @param depths List of all depths
         * @return number of depth increases
         */
        fun findNumIncreases(depths: List<Int>): Int {
            var prevDepth = depths.first()
            var increases = 0
            for (depth in depths.subList(1, depths.size)) {
                if (depth > prevDepth)
                    increases++
                prevDepth = depth
            }
            return increases
        }

        /**
         * Finds the number of depth increases by comparing a three measurement sliding window of depths
         * @param depths List of all depths
         * @return number of depth increases
         */
        fun findNumIncreasedWindow(depths: List<Int>): Int {
            var prevSum = depths[0] + depths[1] + depths[2]
            var increases = 0
            for (i in 1..depths.size - 3) {
                val sum = depths[i] + depths[i + 1] + depths[i + 2]
                if (sum > prevSum)
                    increases++
                prevSum = sum
            }
            return increases
        }
    }
}