import java.util.Scanner

fun main() {
    // put your code here
    val scan = Scanner(System.`in`)
    val a = scan.nextInt()
    val b = scan.nextInt()
    val n = scan.nextInt()
    var count = 0
    for (i in a..b){
        if (i%n == 0)
            count++
    }
    println(count)

}