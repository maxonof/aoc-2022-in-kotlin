fun main() {
    val input = readInput("input2")
    val res = input.sumOf {
        val s = it.split(" ")
        val ss = getActualScore(s.last(), s.first())
        println(ss)
        ss
    }
    println(res)
}


fun getScore(mine: String, theirs: String): Int {
    return when (mine) {
        "Y" -> {
            when (theirs) {
                "A" -> 8
                "B" -> 5
                else -> 2
            }
        }
        "Z" -> {
            when (theirs) {
                "A" -> 3
                "B" -> 9
                else -> 6
            }
        }
        else -> {
            when (theirs) {
                "A" -> 4
                "B" -> 1
                else -> 7
            }
        }
    }
}

fun getActualScore(mine: String, theirs: String): Int {
    return when (mine) {
        "Y" -> {
            when (theirs) {
                "A" -> 4
                "B" -> 5
                else -> 6
            }
        }
        "Z" -> {
            when (theirs) {
                "A" -> 8
                "B" -> 9
                else -> 7
            }
        }
        else -> {
            when (theirs) {
                "A" -> 3
                "B" -> 1
                else -> 2
            }
        }
    }
}
