package cl.ravenhill.transformlist

/**
 * Extension function to halve each element in a list of doubles.
 *
 * ## Usage:
 * This function takes a list of doubles and returns a new list where each element is halved.
 *
 * ### Example 1: Halving elements in a list of doubles
 * ```
 * val numbers = listOf(2.0, 5.0, 6.6)
 * val halvedNumbers = numbers.halved()
 * println(halvedNumbers) // Output: [1.0, 2.5, 3.3]
 * ```
 * ### Example 2: Halving an empty list
 * ```
 * val emptyList = listOf<Double>()
 * val halvedEmptyList = emptyList.halved()
 * println(halvedEmptyList) // Output: []
 * ```
 * @receiver List of doubles to be halved.
 * @return A new list of doubles where each element is halved.
 */
fun List<Double>.halved() = map { it / 2 }
