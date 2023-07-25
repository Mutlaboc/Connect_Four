fun main() {    
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    // Do not touch lines above
    // Write only exchange actions here.
    val buf = numbers.last()
    numbers[numbers.size-1] = numbers.first()
    numbers[0] = buf
    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}