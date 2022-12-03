fun main() {
    val input = readInput("input03")
    val uppercase = 'A' until '['
    val lowercase = 'a' until '{'
    val values = (lowercase + uppercase).zip(1 until 53).toMap()
    println(part1(input, values))
    println(part2(input, values))
}

fun findCommon(line: String): Char {
    val mid = line.length / 2
    val intersection = (0 until mid).map { line[it] }.toSet() intersect
            (mid until line.length).map { line[it] }.toSet()
    return intersection.last()
}

fun part1(input: List<String>, values: Map<Char, Int>): Int {
    return input.sumOf { l -> values.getOrDefault(findCommon(l), 0) }

}

fun part2(input: List<String>, values: Map<Char, Int>): Int {
    return input.chunked(3).sumOf { c ->
        values.getOrDefault(
            c.map { it.toSet() }.reduce { a, b -> a intersect b }.last(), 0
        )
    }
}

