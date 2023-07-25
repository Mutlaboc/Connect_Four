fun main() {
    // write your code here
    val number = readln()
    var firstSumm = 0
    var secondSumm = 0
    for (i in 0 until (number.length/2))
    {
        firstSumm+= number[i].digitToInt()
        secondSumm+=number[number.length-(1+i)].digitToInt()
        //println("суммирование числа ${number[i].digitToInt()} и  ${number[number.length-(1+i)].digitToInt()}")
    }
    println(if (firstSumm-secondSumm == 0) "YES" else "NO")
}