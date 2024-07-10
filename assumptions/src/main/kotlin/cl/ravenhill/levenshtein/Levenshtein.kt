package cl.ravenhill.levenshtein

infix fun String.levenshtein(other: String): Int {
    val m = this.length
    val n = other.length
    val dp = Array(m + 1) { IntArray(n + 1) { it } }

    for (i in 1..m) dp[i][0] = i

    for (i in 1..m) {
        for (j in 1..n) {
            val cost = if (this[i - 1] == other[j - 1]) 0 else 1
            dp[i][j] = minOf(
                dp[i - 1][j] + 1,
                dp[i][j - 1] + 1,
                dp[i - 1][j - 1] + cost
            )
        }
    }

    return dp[m][n]
}
