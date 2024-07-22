
fun main() {
    val input = readln()
    var encodedString = ""
    var count = 1

    for (i in 0 until input.length - 1) {
        if (input[i] == input[i + 1]) {
            count++
        } else {
            encodedString += "${input[i]}$count"
            count = 1
        }
    }

    encodedString += "${input[input.length - 1]}$count"
    println(encodedString)
}