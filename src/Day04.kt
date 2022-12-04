fun main() {
    val input = readInput("input4")
    val splits = input.map { it.split(",") }
    val pairs = splits.map { Pair(toPair(it[0]), toPair(it[1])) }

    val part1 = { a: Pair<Int, Int>, b: Pair<Int, Int> ->
        (a.first <= b.first && b.second <= a.second) || (b.first <= a.first && a.second <= b.second)
    }

    val part2 = { a: Pair<Int, Int>, b: Pair<Int, Int> ->
        (a.first <= b.first && b.first <= a.second) ||
        (a.first <= b.second && b.second <= a.second) ||
        (b.first <= a.first && a.first <= b.second) ||
        (b.first <= a.second && a.second <= b.second)
    }

    println(transformer(pairs, part1))
    println(transformer(pairs, part2))
}

fun transformer(input: List<Pair<Pair<Int, Int>, Pair<Int, Int>>>, condition: (Pair<Int, Int>, Pair<Int, Int>) -> Boolean): Int {
    return input.map { if (condition.invoke(it.first, it.second)) 1 else 0 }.sum()
}

fun toPair(line: String): Pair<Int, Int> {
    val splits = line.split("-").map { it.toInt() }
    return Pair(splits[0], splits[1])
}
