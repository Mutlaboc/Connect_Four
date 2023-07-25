fun main() {
    // write your code here
    val sizeOfList = readln().toInt()
    val listInteg = mutableListOf<Int>()
    repeat(sizeOfList){
        listInteg.add(readln().toInt())
    }
    var yesOrNo = false
    var(p ,m)= readln().split(" ")
    //("Первое число $p")
    //println(("Второе число $m "))
    for (i in 1 until sizeOfList-1) {
        //println("Сравнение ${listInteg[i]} и ${listInteg[i-1]}")
        //println("Сравнение ${listInteg[i]} и ${listInteg[i+1]}")
        if (listInteg[i] == p.toInt()){
            if ((listInteg[i-1] - m.toInt()) == 0)  yesOrNo = true
            if (listInteg[i+1] == m.toInt()) yesOrNo = true
            else continue
        }

    }
    //println(("Перед финальной проверкой $yesOrNo "))
    if (listInteg[0] == p.toInt()) if  (listInteg[1] == m.toInt()) yesOrNo = true
    if (listInteg[sizeOfList-1] == p.toInt()) if  (listInteg[sizeOfList-2] == m.toInt()) yesOrNo =true
    if (yesOrNo) println("NO") else println("YES")
}