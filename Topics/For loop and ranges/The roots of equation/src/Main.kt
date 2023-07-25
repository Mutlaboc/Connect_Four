fun main() {
    // put your code here
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()

    for (i in 0..1000) {
        val root = (a*(i*i*i))+(b*(i*i))+(c*i)+d
        if (root ==0) println(i)


    }
}