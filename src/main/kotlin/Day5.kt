import java.io.File

/**
 * @author Dominik Birngruber
 */
class Day5 {
    /**
     * helper class to save vent data
     * @param vent1 first vent
     * @param vent2 second vent
     */
    data class Segment(val vent1: Pair<Int, Int>, val vent2: Pair<Int, Int>)
    companion object {
        /**
         * reads all vent segments form a given file
         * @param filename the location of the file
         * @return a list of all segments
         */
        fun readSegments(filename: String): List<Segment> {
            val segments = mutableListOf<Segment>()
            val lines = File(filename).readLines()
            for (line in lines) {
                val x1 = line.split(" -> ")[0].split(",")[0].toInt()
                val y1 = line.split(" -> ")[0].split(",")[1].toInt()
                val x2 = line.split(" -> ")[1].split(",")[0].toInt()
                val y2 = line.split(" -> ")[1].split(",")[1].toInt()

                segments.add(Segment(Pair(x1, y1), Pair(x2, y2)))
            }
            return segments
        }

        /**
         * finds all danger zones where at least two vent segments intersect. filters all diagonal vent segments.
         * @param segments list of all segments
         * @return number of danger zones
         */
        fun findDangerZonesHorVer(segments: List<Segment>): Int {
            val filteredSegments =
                segments.filter { it.vent1.first == it.vent2.first || it.vent1.second == it.vent2.second }

            var highestCoord = 0

            for (segment in segments) {
                if (segment.vent1.first > highestCoord) {
                    highestCoord = segment.vent1.first
                }
                if (segment.vent1.second > highestCoord) {
                    highestCoord = segment.vent1.second
                }
                if (segment.vent2.first > highestCoord) {
                    highestCoord = segment.vent2.first
                }
                if (segment.vent2.second > highestCoord) {
                    highestCoord = segment.vent2.second
                }
            }

            val coords = Array(highestCoord + 1) { IntArray(highestCoord + 1) { 0 } }

            for (segment in filteredSegments) {
                if (segment.vent1.first == segment.vent2.first) {
                    val row = segment.vent1.first

                    if (segment.vent1.second < segment.vent2.second) {
                        for (i in segment.vent1.second..segment.vent2.second) {
                            coords[row][i]++
                        }
                    } else {
                        for (i in segment.vent2.second..segment.vent1.second) {
                            coords[row][i]++
                        }
                    }
                } else {
                    val col = segment.vent1.second

                    if (segment.vent1.first < segment.vent2.first) {
                        for (i in segment.vent1.first..segment.vent2.first) {
                            coords[i][col]++
                        }
                    } else {
                        for (i in segment.vent2.first..segment.vent1.first) {
                            coords[i][col]++
                        }
                    }
                }
            }

            return coords.flatMap { it.asIterable() }.count { it >= 2 }
        }

        /**
         * finds all danger zones where at least two vent segments intersect.
         * @param segments list of all segments
         * @return number of danger Zones
         */
        fun findAllDangerZones(segments: List<Segment>): Int {
            var highestCoord = 0

            for (segment in segments) {
                if (segment.vent1.first > highestCoord) {
                    highestCoord = segment.vent1.first
                }
                if (segment.vent1.second > highestCoord) {
                    highestCoord = segment.vent1.second
                }
                if (segment.vent2.first > highestCoord) {
                    highestCoord = segment.vent2.first
                }
                if (segment.vent2.second > highestCoord) {
                    highestCoord = segment.vent2.second
                }
            }

            val coords = Array(highestCoord + 1) { IntArray(highestCoord + 1) { 0 } }

            for (segment in segments) {
                val diff1 = segment.vent1.first - segment.vent2.first
                val diff2 = segment.vent1.second - segment.vent2.second

                if (segment.vent1.first == segment.vent2.first) {
                    //region horizontal
                    val row = segment.vent1.first

                    if (segment.vent1.second < segment.vent2.second) {
                        for (i in segment.vent1.second..segment.vent2.second) {
                            coords[row][i]++
                        }
                    } else {
                        for (i in segment.vent2.second..segment.vent1.second) {
                            coords[row][i]++
                        }
                    }
                    //endregion
                } else if (segment.vent1.second == segment.vent2.second) {
                    //region vertical
                    val col = segment.vent1.second

                    if (segment.vent1.first < segment.vent2.first) {
                        for (i in segment.vent1.first..segment.vent2.first) {
                            coords[i][col]++
                        }
                    } else {
                        for (i in segment.vent2.first..segment.vent1.first) {
                            coords[i][col]++
                        }
                    }
                    //endregion
                } else if ((diff1 == diff2) && diff1 < 0) {
                    //region left -> right | downwards
                    val startx = segment.vent1.first
                    val starty = segment.vent1.second
                    val endx = segment.vent2.first
                    val endy = segment.vent2.second

                    var i = startx
                    var j = starty

                    while (i <= endx && j <= endy) {
                        coords[i][j]++
                        i++
                        j++
                    }
                    //endregion
                } else if ((diff1 == diff2) && diff1 > 0) {
                    //region right -> left | upwards
                    val startx = segment.vent2.first
                    val starty = segment.vent2.second
                    val endx = segment.vent1.first
                    val endy = segment.vent1.second

                    var i = startx
                    var j = starty

                    while (i <= endx && j <= endy) {
                        coords[i][j]++
                        i++
                        j++
                    }
                    //endregion
                } else if (diff1 > diff2) {
                    //region left -> right | upwards
                    val startx = segment.vent2.first
                    val starty = segment.vent2.second
                    val endx = segment.vent1.first
                    val endy = segment.vent1.second

                    var i = startx
                    var j = starty

                    while (i <= endx && j >= endy) {
                        coords[i][j]++
                        i++
                        j--
                    }
                    //endregion
                } else {
                    //region right -> left | downwards
                    val startx = segment.vent2.first
                    val starty = segment.vent2.second
                    val endx = segment.vent1.first
                    val endy = segment.vent1.second

                    var i = startx
                    var j = starty

                    while (i >= endx && j <= endy) {
                        coords[i][j]++
                        i--
                        j++
                    }
                    //endregion
                }
            }

            return coords.flatMap { it.asIterable() }.count { it >= 2 }
        }
    }
}