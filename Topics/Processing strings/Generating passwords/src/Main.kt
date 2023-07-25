import java.util.Scanner

fun main() {
    // write your code here
    val scan = Scanner(System.`in`)
    val upperCase = ('A'..'Z').joinToString("")
    val lowerCase = ('a'..'z').joinToString("")
    val digits = ('0'..'9').joinToString("")
    val remainder = "z$upperCase$lowerCase$digits"

    var upperCAseCount = scan.next().toInt()
    var lowerCaseCount = scan.next().toInt()
    var digitsCount = scan.next().toInt()
    var numberOFSymbols = scan.next().toInt()
    var password = ""

    /* while (upperCAseCount > 0) {
        password += (upperCase.subSequence(0..upperCAseCount))
    }
    password +=(lowerCase.subSequence(0..lowerCaseCount))
    password += (digits.subSequence(0..9))
    */



   // var pass = mutableListOf<String>()
    for (i in 0 until numberOFSymbols-digitsCount){
        if (i%2==0) {
            if (upperCAseCount >0){
                password += "C"
                upperCAseCount--
            }
            else password += "c"
        }
        else {
            if (upperCAseCount >0) {
                password += "B"
                upperCAseCount--
            }
            else password += "b"
        }
    }
    var digit = 1
    while(digitsCount>0){
        password += if (digitsCount%2==0) {
            "1"
        } else "2"
        digitsCount--
    }

    println(password)



}



