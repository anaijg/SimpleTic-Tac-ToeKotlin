fun solution(elements: Set<String>, element: String): MutableSet<String> {
    // put your code here
    var mSet = mutableSetOf<String>()
    mSet.addAll(elements)
    mSet.remove(element)
    return mSet
}

fun main() {
    println(solution(mutableSetOf("a", "b", "c", "d"), "c"))
}