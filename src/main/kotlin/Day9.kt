import java.io.File

/**
 * @author Dominik Birngruber
 */
class Day9 {
    companion object {
        fun readCaveSystem(filename: String): List<List<Int>> {
            val lines = File(filename).readLines()
            val system = lines.map {
                val integers = mutableListOf<Int>()
                for (c in it) {
                    integers.add(Character.getNumericValue(c))
                }
                integers
            }
            return system
        }

        fun calculateRiskLevel(system: List<List<Int>>): Int {
            var riskRating = 0
            for (row in system.indices) {
                for (col in system[row].indices) {
                    var isLowPoint = true

                    when (row) {
                        0 -> {
                            isLowPoint = system[row][col] < system[1][col]
                        }
                        system.lastIndex -> {
                            isLowPoint = system[row][col] < system[system.lastIndex - 1][col]
                        }
                        else -> {
                            isLowPoint = system[row][col] < system[row + 1][col]
                            isLowPoint = (system[row][col] < system[row - 1][col]) && isLowPoint
                        }
                    }

                    when (col) {
                        0 -> {
                            isLowPoint = (system[row][col] < system[row][1]) && isLowPoint
                        }
                        system[row].lastIndex -> {
                            isLowPoint = (system[row][col] < system[row][system[row].lastIndex - 1]) && isLowPoint
                        }
                        else -> {
                            isLowPoint = (system[row][col] < system[row][col+1]) && isLowPoint
                            isLowPoint = (system[row][col] < system[row][col-1]) && isLowPoint
                        }
                    }

                    if(isLowPoint) {
                        riskRating += system[row][col]+1
                    }
                }
            }
            return riskRating
        }
    }
}