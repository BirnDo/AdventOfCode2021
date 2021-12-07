import java.io.File
import kotlin.math.absoluteValue

/**
 * @author Dominik Birngruber
 */
class Day7 {
    companion object {
        /**
         * reads all positions of crabs from the specified file
         * @param filename the file containing carb positions
         * @return list of positions as integers
         */
        fun readPositions(filename: String): List<Int> = File(filename).readText().split(",").map { it.toInt() }

        /**
         * aligns the crabs by assuming fuel is used linear
         * @param positions the positions of crabs as an Integer List
         * @return the minimum fuel cost
         */
        fun alignCrabsLinear(positions: List<Int>): Int {
            val max = positions.sorted()[positions.lastIndex]

            var lowest = Int.MAX_VALUE

            for (i in 0..max) {
                var fuelSum = 0
                var higher = false

                for (p in positions) {
                    fuelSum += (p - i).absoluteValue
                    if (fuelSum > lowest) {
                        higher = true
                        break
                    }
                }

                if (!higher) {
                    lowest = fuelSum
                }
            }

            return lowest
        }

        /**
         * aligns the crabs by assuming fuel is used exponentially
         * @param positions the positions of crabs as an Integer List
         * @return the minimum fuel cost
         */
        fun alignCrabs(positions: List<Int>): Int {
            val max = positions.sorted()[positions.lastIndex]

            val fuelTable = Array(max+1) { 0 }

            for (i in 1..fuelTable.lastIndex) {
                fuelTable[i] = fuelTable[i-1]+i
            }

            var lowest = Int.MAX_VALUE

            for (i in 0..max) {
                var fuelSum = 0
                var higher = false

                for (p in positions) {
                    fuelSum += fuelTable[(p - i).absoluteValue]
                    if (fuelSum > lowest) {
                        higher = true
                        break
                    }
                }

                if (!higher) {
                    lowest = fuelSum
                }
            }

            return lowest
        }
    }
}