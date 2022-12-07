fun main() {
    val input = readInput("input06").first()

    println(beforePayload(input, 4))
    println(beforePayload(input, 14))
}

fun beforePayload(line:String, targetSize: Int): Int {
    var i = 0
    var j = targetSize
    while (j < line.length) {
        if (isAllDistinct(line.substring(i, j))) {
            return j
        }
        i++
        j++
    }
    return 0
}

fun isAllDistinct(line: String): Boolean {
    return line.chars().distinct().count() == line.length.toLong()
}

