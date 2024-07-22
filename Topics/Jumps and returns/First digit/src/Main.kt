fun main() {
    val word = readln()
    for (i in word.indices) {
        if (word[i].isDigit()) {
            println(word[i])
            break
        }
    }
}