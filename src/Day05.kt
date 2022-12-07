import kotlin.collections.ArrayDeque

fun main() {
    val input = readInput("input05")
    val stacks = listOf(
          ArrayDeque(listOf('B', 'L', 'D', 'T', 'W', 'C', 'F', 'M'))
        , ArrayDeque(listOf('N', 'B', 'L'))
        , ArrayDeque(listOf('J', 'C', 'H', 'T', 'L', 'V'))
        , ArrayDeque(listOf('S', 'P', 'J', 'W'))
        , ArrayDeque(listOf('Z', 'S', 'C', 'F', 'T', 'L', 'R'))
        , ArrayDeque(listOf('W', 'D', 'G', 'B', 'H', 'N', 'Z'))
        , ArrayDeque(listOf('F', 'M', 'S', 'P', 'V', 'G', 'C', 'N'))
        , ArrayDeque(listOf('W', 'Q', 'R', 'J', 'F', 'V', 'C', 'Z'))
        , ArrayDeque(listOf('R', 'P', 'M', 'L', 'H'))
    )

    val numberRegex = "\\d+".toRegex()
    input.subList(10, input.size).forEach { line ->
        val numbers = numberRegex.findAll(line).map { it.value.toInt() }
        val amount = numbers.first()
        val stackFrom = numbers.elementAt(1) - 1
        val stackTo = numbers.last() - 1
        val buffer = ArrayDeque<Char>()
        for (i in 0 until amount) {
            buffer.addLast(stacks[stackFrom].removeLast())
        }
        for (i in 0 until amount) {
            stacks[stackTo].addLast(buffer.removeLast())
        }
    }

    println(stacks.map { it.last() }.joinToString(separator = ""))
}
