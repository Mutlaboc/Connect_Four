fun main() {
    val test = readln()
    if ((test.length)%2 == 0){
    println(test.substring(0,(test.length/2)-1)+test.substring(test.length/2+1,test.length))
    }
    else   println(test.substring(0,(test.length/2))+test.substring(test.length/2+1,test.length))
    }

