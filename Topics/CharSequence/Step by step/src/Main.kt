fun removeEveryOtherChar(input: CharSequence): CharSequence {
    // write your code here
    var sb = ""
    for (i in input.indices) {
        if (i % 2 == 0) sb+=input[i].toString()
    }
    val test:CharSequence = sb


    return test
}