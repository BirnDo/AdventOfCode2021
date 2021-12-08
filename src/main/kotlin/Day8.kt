import java.io.File

/**
 * @author Dominik Birngruber
 */
class Day8 {
    /**
     * helper class to save an entry of the input
     * @param patterns the list of patterns
     * @param digits the list of digits
     */
    data class Entry(var patterns: MutableList<String>, var digits: MutableList<String>)

    companion object {
        /**
         * reads all entries of a given file
         * @param filename the file where entries are contained
         * @return a list of entries
         */
        fun readEntries(filename: String): List<Entry> {
            val lines = File(filename).readLines()
            return lines.map {
                val entry = Entry(mutableListOf(), mutableListOf())
                val entries = it.split(" ")
                var delimited = false
                for (e in entries) {
                    if (e == "|") {
                        delimited = true
                        continue
                    }

                    if (delimited) {
                        entry.digits.add(e)
                    } else {
                        entry.patterns.add(e)
                    }
                }
                entry
            }.toList()
        }

        /**
         * finds all easy digits (1,4,7,8)
         * @param entries list of entries
         * @return number of easy digits
         */
        fun findEasyDigits(entries: List<Entry>): Int =
            entries.flatMap { it.digits }.map { it.length }.count { it == 2 || it == 3 || it == 4 || it == 7 }

        //
        // finds the sum of all digits
        // @param entries list of entries
        // @return sum of all digits in the entries
        //
        //fun findDigits(entries: List<Entry>): Int{
            // could not finish part two
            // return 0
        //}
    }
}