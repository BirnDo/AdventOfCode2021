import java.io.File

/**
 * @author Dominik Birngruber
 */
class Day4 {
    /**
     * data class to save a game
     * @param numbers the winning numbers in the picked order
     * @param boards all available boards
     */
    data class BingoGame(var numbers: List<Int>, var boards: List<Board>)

    /**
     * data class to store a single board
     * @param fields all numbers saved in a 2D Array
     */
    data class Board(var fields: MutableList<MutableList<Int>> = mutableListOf())

    companion object {
        /**
         * reads the game from a file
         * @param filename the path to the game file
         * @return the whole game in the file
         */
        fun readGameInput(filename: String): BingoGame {
            val boards = mutableListOf<Board>()
            val lines = File(filename).readLines().filter { it.isNotEmpty() }

            val nums = lines[0].split(",").map { it.toInt() }.toList()

            var rowcount = 0
            var board = Board()

            for (i in 1..lines.lastIndex) {

                val numbers = lines[i].split(" ").filter { it != "" }.map { it.toInt() }.toMutableList()
                board.fields.add(numbers)
                rowcount++

                if (rowcount == 5) {
                    boards.add(board)
                    board = Board()
                    rowcount = 0
                    continue
                }
            }

            return BingoGame(nums, boards)
        }

        /**
         * goes through all picked numbers and calculates the score of the winning one
         * @param game the whole bingo game
         * @return the score of the winning board
         */
        fun solveBingoGame(game: BingoGame): Int {
            for (num in game.numbers) {
                for (i in game.boards.indices) {
                    for (j in 0..4) {
                        for (k in 0..4) {
                            if (game.boards[i].fields[j][k] == num) {
                                game.boards[i].fields[j][k] = -1
                            }
                        }
                    }
                }

                for (board in game.boards) {
                    if (boardIsFinished(board)) {
                        return board.fields.flatten().filter { it != -1 }.sum() * num
                    }
                }
            }

            return 0
        }

        /**
         * checks if a board has gotten a bingo
         * @param board a single bingo board
         * @return whether the board has won or not
         */
        private fun boardIsFinished(board: Board): Boolean {
            for (row in board.fields) {
                if (row.sum() == -5) {
                    return true
                }
            }

            for (j in 0..4) {
                var colSum = 0
                for (i in 0..4) {
                    colSum += board.fields[i][j]
                }
                if (colSum == -5) {
                    return true
                }
            }

            return false
        }

        /**
         * finds the losing board of a bingo game
         * @param game the whole bingo game
         * @return the score of the losing board
         */
        fun findLosingGame(game: BingoGame): Int {
            for (num in game.numbers) {
                for (i in game.boards.indices) {
                    for (j in 0..4) {
                        for (k in 0..4) {
                            if (game.boards[i].fields[j][k] == num) {
                                game.boards[i].fields[j][k] = -1
                            }
                        }
                    }
                }

                if (game.boards.size > 1)
                    game.boards = game.boards.filter { !boardIsFinished(it) }

                if(boardIsFinished(game.boards[0])) {
                    return game.boards[0].fields.flatten().filter { it != -1 }.sum() * num
                }
            }

            return 0
        }
    }
}