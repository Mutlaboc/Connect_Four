fun countVowels(charSequence: CharSequence): Int {
    // write your code here
    val valid = setOf<Char>('a', 'e', 'i', 'o', 'u', 'y')
    val filtered = charSequence.filter { it in valid }
    return filtered.length
}