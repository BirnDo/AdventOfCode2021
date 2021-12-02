/**
 * @author Dominik Birngruber
 */
import java.io.File

class Day2 {

    /**
     * a data class for mapping commands
     * @param direction The direction as a String (either up, down or forward)
     * @param units The amount of units to move in this direction
     */
    data class Command(val direction: String, val units: Int)

    companion object {
        /**
         * reads all directions from the given file, where the direction format is <code>String Int</code>
         * @param filename the file with the directions
         * @return list of commands
         */
        fun readDirections(filename: String): List<Command> {
            val comms = mutableListOf<Command>()
            File(filename).readLines()
                .map { Pair(it.split(" ")[0], it.split(" ")[1]) }
                .forEach { comms.add(Command(it.first, it.second.toInt())) }
            return comms
        }

        /**
         * executes the given commands by either going up or down by <code>X</code> units or moving forward by <code>X</code> units
         * @param comms list of commands
         * @return the multiple of the final horizontal and vertical position
         */
        fun executeCommands(comms: List<Command>): Int {
            var horizontal = 0
            var vertical = 0

            comms.forEach {
                when (it.direction) {
                    "forward" -> horizontal += it.units
                    "up" -> vertical -= it.units
                    "down" -> vertical += it.units
                }
            }

            return horizontal * vertical
        }

        /**
         * executes the commands by either changing aim for up and down by <code>X<code> units or moving
         * forward horizontally by <code>X</code> units and vertically by <code>X * aim</code> units
         * @param comms list of commands
         * @return the multiple of the final horizontal and vertical positions
         */
        fun executeCommandsByAim(comms: List<Command>): Int {
            var horizontal = 0
            var vertical = 0
            var aim = 0

            comms.forEach {
                when (it.direction) {
                    "forward" -> {
                        horizontal += it.units
                        vertical += aim * it.units
                    }
                    "up" -> aim -= it.units
                    "down" -> aim += it.units
                }
            }

            return horizontal * vertical
        }
    }
}