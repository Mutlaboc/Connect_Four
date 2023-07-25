fun main() {
    // write your code here
    var elem = readln().toInt()
    val elemList = mutableListOf<Int>()
    repeat(elem){
        elemList.add(readln().toInt())
    }
    var rotation = readln().toInt()
    if (rotation > elemList.size) {
        rotation %= elemList.size
    }
    val newList = mutableListOf<Int>()
    for (i in 0 until elemList.size){
        //println("Проверка числа с инд $i")
       // println(elemList.size)
        newList += if ((i-rotation)<0){
            elemList[elemList.size - (rotation-i)]
        } else elemList[i-rotation]
    }
    println(newList.joinToString(" "))


}