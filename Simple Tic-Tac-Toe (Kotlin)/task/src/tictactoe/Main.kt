package tictactoe

import javax.swing.DefaultRowSorter
import kotlin.math.absoluteValue

var gameState = "          "

var board = mutableListOf(
    mutableListOf(gameState[0], gameState[1], gameState[2]),
    mutableListOf(gameState[4], gameState[5], gameState[6]),
    mutableListOf(gameState[7], gameState[8], gameState[9])
)

fun updateBoard() {
    var i = 0
    for (row in 0..2) {
        for (column in 0..2) {
            board[row][column] = gameState[i]
            i++
        }
    }
}

fun printBoard() {
    println("---------")
    for (i in 0..2) {
        print("| ")
        for (j in 0..2) {
            print(board[i][j] + " ")
        }
        println("|")
    }
    println("---------")
}

fun analyse():String {
    var str = ""
    var xwins = checkIfWins('X')
    var oWins = checkIfWins('O')
    // check impossible
    val xCount = gameState.count { it == 'X' }
    val oCount = gameState.count { it == 'O' }
    val difference = (xCount - oCount).absoluteValue
    if (xwins && oWins || difference > 1) {
        return "Impossible"
    } else if (xwins) {
        return "X wins"
    } else if (oWins) {
        return "O wins"
    }
    if (!gameState.contains('_')) {
        return "Draw"
    } else {
        return "Game not finished"
    }
}

fun checkIfWins(character: Char): Boolean {
    for (row in 0..2) {
        if (
            board[row][0] == board[row][1] &&
            board[row][1] == board[row][2] &&
            board[row][0] == character
            ) {
            return true
        }
    }
    for (column in 0..2) {
        if (
            board[0][column] == board[1][column] &&
            board[1][column] == board[2][column] &&
            board[0][column] == character) {
            return true
        }
    }
    if (
        board[0][0] == board[1][1] &&
        board[1][1] == board[2][2] &&
        board[2][2] == character) {
        return true
    }
    if (board[0][2] == board[1][1] &&
        board[1][1] == board[2][0] &&
        board[0][2] == character) {
        return true
    }
    return false
}

fun analyseInput(input: String) {
    var (row, column) = input.split(" ")
    var correctInput = false
    while (!correctInput) {
        if (!row.first().isDigit() || !column.first().isDigit()) {
            println("You should enter numbers!")
        } else if (row.toInt() < 1 || row.toInt() > 3 || column.toInt() < 1 || column.toInt() > 3) {
            println("Coordinates should be from 1 to 3!")
        } else if (
            board[row.toInt() - 1][column.toInt() - 1] == 'X' ||
            board[row.toInt() - 1][column.toInt() - 1] == 'O') {
            println("This cell is occupied! Choose another one!")
        } else {
            correctInput = true
            board[row.toInt() - 1][column.toInt() - 1] = 'X'
            printBoard()
        }
        if (!correctInput) {
            val read = readln().split(" ")
            row = read[0]
            column = read[1]
        }
    }
}


fun main() {
    updateBoard()
    printBoard()
    // the game starts
    var end = ""
    do {
        analyseInput(readln())
        end = analyse()
    } while (end != "X wins" && end != "O wins")
    println(end)
}

