package connectfour

import java.lang.Exception
import java.lang.NumberFormatException
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Connect Four")
    println("First player's name:")
    val firstName = scanner.next()
    println("Second player's name:")
    val secondName = scanner.next()
    var rows = 0
    var columns = 0
    var games = 1
    var multGames = false
    var firstPlayerScore = 0
    var secondPlayerScore = 0
    var changeTurns = false
    fun setBoard () {
        println("Set the board dimensions (Rows x Columns)")
        println("Press Enter for default (6 x 7)")


        val settings = readln().trim().filter { !it.isWhitespace() }.split("x","X")
        //println(settings)

        if (settings.size == 1 && settings[0] == "") {
            rows = 6
            columns = 7}
        else {
            try {rows = settings[0].toInt()}
            catch(e: Exception) {
                println("Invalid input")
                setBoard()
                return

            }
            try {columns = settings[1].toInt()}
            catch(e: Exception) {
                println("Invalid input")
                setBoard()
                return

            }
        }

        if (rows in 5..9) {

            return
        }
        else {
            println("Board rows should be from 5 to 9")
            setBoard()
        }
        if (columns in 5..9){
            return
        }
        else {
            println("Board columns should be from 5 to 9")
            setBoard()
        }

    }

    setBoard()

    fun setGamePlayers () {
        println("Do you want to play single or multiple games?\n" +
                "For a single game, input 1 or press Enter\n" +
                "Input a number of games:")
        val settings = readln().trim()
        if (settings == "")
            games = 1
        else  try {games = settings.toInt()}
        catch(e: Exception) {
            println("Invalid input")
            setGamePlayers()
            return
        }
        if (games < 1){
                println("Invalid input")
                setGamePlayers()
                return

            }

            }
    setGamePlayers()

        println("$firstName VS $secondName")
        println("$rows X $columns board")
        if (games ==1)
        {
            println("Single game")
        }
        else {
            multGames = true
            println("Total $games games")
        }

       var map = mutableListOf<String>()
repeat(rows*columns) {
    map.add("| ")
}
    var lines = map.chunked(rows)
    var mapFull = lines as MutableList<MutableList<String>>

    //println(mapFull)
    fun printField (rows: Int, columns: Int) {
        for (i in 1..columns)
            print(" $i")
        //print("| ")
        println()
        /*repeat(rows){
            repeat(columns+1) { print("| ") }
            println()
        }

         */
        for (i in 0 until rows){
            for (c in 0 until columns){
                print(mapFull[c][i])
            }
            print("| ")
            println()
        }
        //repeat(columns){ print("╚═") }
        //print("╝")
        repeat((columns*2)+1){ print("=") }
        println()
    }
    var turnExsis = true
    //printField(rows, columns)
    fun winCondition (column: Int, rows: Int, playerSymb: String): Boolean  {
        println("колонн - $column")

        var n = 0
        var count = 0
        while ((rows+n) <= rows-1 && mapFull[column][rows+n] == playerSymb){
            count++
            n++
        }
        n = 0
        while ((rows-n) >= 0 && mapFull[column][rows-n] == playerSymb){
            count++
            n++
        }
        if (count >=5) {
            println("Выигрыш горизнтальный ряд")
            return true
        }
        n = 0
        count = 0
        while ((column+n) <= columns-1 && mapFull[column+n][rows] == playerSymb){
            count++
            n++
        }
        n = 0
        while ((column-n) >= 0 && mapFull[column-n][rows] == playerSymb){
            count++
            n++
        }
        println("Вертикаль - $count")
        if (count >=5) {
            println("Выигрыш вертикальный ряд")
            return true
        }
        // диагональ 1
        n = 0
        count = 0
        while ((column+n) <= columns-1 && (rows+n) <= rows-1 && mapFull[column+n][rows+n] == playerSymb){
            count++
            n++
        }
        n = 0
        while ((column-n) >= 0 && (rows-n) >= 0 && mapFull[column-n][rows-n] == playerSymb){
            count++
            n++
        }
        if (count >=5) {
            println("Выигрыш диагональ 1")
            return true
        }
        // диагональ 2
        n = 0
        count = 0
        while ((column+n) <= columns-1 && (rows-n) >= 0  && mapFull[column+n][rows-n] == playerSymb){
            count++
            n++
        }
        n = 0
        while ((column-n) >= 0 && (rows+n) <= rows-1 && mapFull[column-n][rows+n] == playerSymb){
            count++
            n++
        }
        if (count >=5) {
            println("Выигрыш диагональ 2")
            return true
        }
        return false
    }
    fun winCondRegex (symbol: String):Int {
        var maptext = ""
        for (line in mapFull) {
            maptext+=line.joinToString("")
            maptext+="|||||"
        }
        //println(maptext)
        //var map = mapFull.toString()
        //println(mapFull.joinToString(""))

        val test = mapFull.joinToString("")
        //val c1 = "[|]$sym[|]$sym[|]$sym[|]$sym".toRegex()
        //val c1 = "[|]$sym[*]{6}[|]$sym[*]{6}[|]$sym[*]{6}[|]$sym".toRegex()
        val c2 = "$symbol.{${(rows * 2) + 4}}$symbol.{${(rows * 2) + 4}}$symbol.{${(rows * 2) + 4}}$symbol".toRegex()
        val c3 = "$symbol.$symbol.$symbol.$symbol".toRegex()
        val c4 = "$symbol.{${((rows + 1) * 2) + 4}}$symbol.{${((rows + 1) * 2) + 4}}$symbol.{${((rows + 1) * 2) + 4}}$symbol".toRegex()
        val c5 = "$symbol.{${((rows - 1) * 2) + 4}}$symbol.{${((rows - 1) * 2) + 4}}$symbol.{${((rows - 1) * 2) + 4}}$symbol".toRegex()
        /*for ( i in 0 until mapFull.size){
            //println("${test[0]} werwesf")
            if (mapFull[i].joinToString("").contains(c1)) {

                println(mapFull[i].toString())
                println("Winner")
            }
        }
        */


        if (c2 in maptext) {

           // println("вертикаль")
            //println(maptext)
            return 1
        }

        if (c3 in maptext) {

           // println("горизонталь")
           // println(maptext)
            return 1
        }
        if (c4 in maptext) {
           // println("диагональ")
           // println(maptext)
            return 1
        }
        if (c5 in maptext) {
            //println("диагональ 2")
            //println(maptext)
            return 1
        }
        if (!maptext.contains(" ")){
            return 2
        }

        return 3
    }
    fun playerOneTurn (){
            var wincond = false

            turnExsis = false
            println("$firstName's turn:")
            var column = readln()
            if (column == "end") {
                games = 0
                println("Game over!")
                turnExsis = false
                return
            }
        try {
            val test = column.toInt()
        }
        catch (e:NumberFormatException) {
            println("Incorrect column number")
            playerOneTurn()
            return
        }
        if (column.toInt() !in 1..columns) {
            println("The column number is out of range (1 - $columns)")
            playerOneTurn()
            return
        }
            for (i in rows - 1 downTo 0) {
                if (mapFull[column.toInt() - 1][i] == "| ") {
                    mapFull[column.toInt() - 1][i] = "|o"
                    turnExsis = true
                   // wincond = winCondition(column.toInt() - 1,i,"|o")
                    break

                }
            }

            if (!turnExsis) {
                println("Column $column is full")
                playerOneTurn()
                return
            }
            printField(rows, columns)

            if (winCondRegex("o") == 1){
                println("Player $firstName won")

                turnExsis = false
                if (multGames){
                    games--
                    firstPlayerScore += 2
                    println("Score\n" +
                            "$firstName: $firstPlayerScore $secondName: $secondPlayerScore")
                }
                if(games<1) println("Game Over!")
                return@playerOneTurn
            }
        if (winCondRegex("o") == 2){
            println("It is a draw")

            if (multGames){
                games--
                firstPlayerScore +=1
                secondPlayerScore +=1
                println("Score\n" +
                        "$firstName: $firstPlayerScore $secondName: $secondPlayerScore")
            }
            if(games<1) println("Game Over!")
            turnExsis = false
            return@playerOneTurn
        }
            }
        fun playerTwoTurn (){
            var wincond = false
            turnExsis = false
            println("$secondName's turn:")
            var column = readln()
            if (column == "end") {
                games = 0
                println("Game over!")
                turnExsis = false
                return
            }
            try {
                val test = column.toInt()
            }
            catch (e:NumberFormatException) {
                println("Incorrect column number")
                playerTwoTurn()
                return
            }
            if (column.toInt() !in 1..columns) {
                println("The column number is out of range (1 - $columns)")
                playerTwoTurn()
                return
            }
            for (i in rows - 1 downTo 0) {
                if (mapFull[column.toInt() - 1][i] == "| ") {
                    mapFull[column.toInt() - 1][i] = "|*"
                    turnExsis = true
                   // wincond = winCondition(column.toInt() - 1,i,"|*")
                    break

                }
            }

            if (!turnExsis) {
                println("Column $column is full")
                playerTwoTurn()
                return
            }
            printField(rows, columns)

            if (winCondRegex("\\*") == 1){
                println("Player $secondName won")

                if (multGames){
                    games--
                    secondPlayerScore +=2
                    println("Score\n" +
                            "$firstName: $firstPlayerScore $secondName: $secondPlayerScore")
                }
                if(games<1) println("Game Over!")
                turnExsis = false
                return@playerTwoTurn

            }
            if (winCondRegex("\\*") == 2){
                println("It is a draw")

                if (multGames){
                    games--
                    firstPlayerScore +=1
                    secondPlayerScore+=1
                    println("Score\n" +
                            "$firstName: $firstPlayerScore $secondName: $secondPlayerScore")
                }
                if(games<1) println("Game Over!")
                turnExsis = false
                return
            }
    }
var countTurns = 1
while (games>0) {
    for (i in 0..mapFull.size-1) {
        for (c in 0..mapFull[i].size-1){
            if (mapFull[i][c] == "|*") mapFull[i][c]= "| "
            if (mapFull[i][c] == "|o") mapFull[i][c]= "| "

        }
    }
    changeTurns = !changeTurns
    //println(changeTurns)
    turnExsis = true
    if (multGames) println("Game #$countTurns")
    countTurns++
    printField(rows, columns)
    while (turnExsis){
        if (changeTurns){
            playerOneTurn()
            if (!turnExsis) break
            playerTwoTurn()
        }
        else {
            playerTwoTurn()
            if (!turnExsis) break
            playerOneTurn()
        }
    }
    }
}