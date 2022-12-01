fun main() {
    val input = readInput("input")
    val elfs = mutableListOf<Int>()
    var current = 0
    for (l in input) {
        if (l.isEmpty()) {
            elfs.add(current)
            current = 0
        } else {
            current += l.toInt()
        }
    }
    elfs.add(current)

    elfs.sort()

    println(elfs.last() + elfs[elfs.size - 2] + elfs[elfs.size - 3])
}
