fun main() {
    // put your code here
    val word = readln()
    //val alphabet = "abcdefghijklmnopqrstuvwxyz"
    val alphabet = mutableListOf<Char>('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    for (char in word)
    {
        alphabet.remove(char)
    }
    for (char in alphabet)
        print(char)
}