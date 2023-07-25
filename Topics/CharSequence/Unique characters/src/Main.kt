fun countUniqueChars(sequence: CharSequence): Int {
    // write your code here
    var charSet = sequence.toSet()
    return charSet.size

}