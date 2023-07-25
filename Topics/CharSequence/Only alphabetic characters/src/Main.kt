fun containsOnlyAlphabets(charSequence: CharSequence): Boolean
{
    // write your code here
    for (char in charSequence){
        val lowerChar = char.lowercaseChar()
        //println(lowerChar.code)
        if (lowerChar.code !in 97..122){

            return false

        }
    }
    return true
}