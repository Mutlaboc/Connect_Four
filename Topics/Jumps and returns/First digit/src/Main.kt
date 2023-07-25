fun main() {
    // put your code here
    val text = readln()
    val textFiltr = text.filter { it.isDigit() }
    println(textFiltr[0])
}