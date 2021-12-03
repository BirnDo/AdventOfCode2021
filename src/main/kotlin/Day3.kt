import java.io.File

/**
 * @author Dominik Birngruber
 */
class Day3 {
    companion object {
        /**
         * reads all binary Data from the given file
         * @param filename location of the file
         * @return a list of binary data as string
         */
        fun readBinaryData(filename: String) = File(filename).readLines().toList()

        /**
         * calculates the power consumption by determining the gamma and epsilon rate and multiplying them
         * @param binaryData the data as a string list
         * @return the power consumption a decimal Integer
         */
        fun calculateConsumption(binaryData: List<String>): Int {
            var gammaRate = ""
            var epsilonRate = ""
            val binaryLength = binaryData.first().lastIndex

            //region determine rates
            for (i in 0..binaryLength) {
                var numOne = 0
                var numZero = 0
                for (data in binaryData) {
                    if (data[i] == '1')
                        numOne++
                    else
                        numZero++
                }
                if (numOne > numZero) {
                    gammaRate += "1"
                    epsilonRate += "0"
                } else {
                    gammaRate += "0"
                    epsilonRate += "1"
                }
            }
            //endregion

            return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)
        }

        /**
         * calculates teh life support rating by determining the oxygen generator rating and the CO2 scrubber rating
         * and multiplying them
         * @param binaryData the data as a string list
         * @return the life support rating as a decimal integer
         */
        fun findLifeSupportRating(binaryData: List<String>): Int {
            val binaryLength = binaryData.first().lastIndex
            var oxygen = ""
            var CO2 = ""

            //region determine oxygen generator reting
            var generatorRating = binaryData
            for (i in 0..binaryLength) {
                var numOne = 0
                var numZero = 0
                for (data in generatorRating) {
                    if (data[i] == '1')
                        numOne++
                    else
                        numZero++
                }
                generatorRating = if (numOne >= numZero) {
                    generatorRating.filter { it[i] == '1' }
                } else {
                    generatorRating.filter { it[i] == '0' }
                }

                if (generatorRating.size == 1) {
                    oxygen = generatorRating.first()
                    break
                }
            }
            //endregion

            //region determine CO2 scrubber rating
            var CO2scrubber = binaryData
            for (i in 0..binaryLength) {
                var numOne = 0
                var numZero = 0
                for (data in CO2scrubber) {
                    if (data[i] == '1')
                        numOne++
                    else
                        numZero++
                }
                CO2scrubber = if (numOne < numZero) {
                    CO2scrubber.filter { it[i] == '1' }
                } else {
                    CO2scrubber.filter { it[i] == '0' }
                }

                if (CO2scrubber.size == 1) {
                    CO2 = CO2scrubber.first()
                    break
                }
            }
            //endregion

            return Integer.parseInt(oxygen, 2) * Integer.parseInt(CO2, 2)
        }
    }
}