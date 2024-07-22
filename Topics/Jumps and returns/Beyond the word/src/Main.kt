fun main() {
    val word = readln()
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    for (i in alphabet.indices) {
        if (word.contains(alphabet[i])) {
            continue
        } else print(alphabet[i])
    }
}