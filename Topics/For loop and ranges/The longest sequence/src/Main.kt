import java.util.Scanner


fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val range = scanner.nextInt()
    var prevNum = scanner.nextInt()
    var seq = 1
    var result = 0
    for (i in 2..range){
            var curNum = scanner.nextInt()
       // println("__________")
       // println("Проверка номера $curNum")

        if (prevNum<=curNum){
           //println("сравнение $prevNum и $curNum")
            seq++
            prevNum = curNum
           //println("промежуточный порядок - $seq")
        }
        else {
            if (result<seq) result=seq
            //println("сравнение $prevNum и $curNum - сброй порядка")
            //println("Сбой порядок - $seq")
            prevNum = curNum
            seq = 1

        }
    }
    if (seq>result)
    println(seq)
    else
        println(result)
}