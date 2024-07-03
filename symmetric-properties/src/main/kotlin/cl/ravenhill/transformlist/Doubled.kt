package cl.ravenhill.transformlist

/**
 * Extension function to double each element in a list of doubles.
 *
 * ## Usage:
 * This function takes a list of doubles and returns a new list where each element is doubled.
 *
 * ### Example 1: Doubling elements in a list of doubles
 * ```
 * val numbers = listOf(1.0, 2.5, 3.3)
 * val doubledNumbers = numbers.doubled()
 * println(doubledNumbers) // Output: [2.0, 5.0, 6.6]
 * ```
 * ### Example 2: Doubling an empty list
 * ```
 * val emptyList = listOf<Double>()
 * val doubledEmptyList = emptyList.doubled()
 * println(doubledEmptyList) // Output: []
 * ```
 * @receiver List of doubles to be doubled.
 * @return A new list of doubles where each element is doubled.
 */
fun List<Double>.doubled() = map { it * 2 }
