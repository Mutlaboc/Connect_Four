fun main() {
    var text = readln()
    //("Длина текста"+ text.length + "половина"+(text.length/2))
    /*for (i  in 0..text.length/2){
        if (text[i] == text[text.length-1-i]) continue
        else {
            println("no")
            break

        }
    }
    println("yes")
    */

    if (text.reversed() == text) println("yes") else println("no")
}