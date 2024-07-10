package cl.ravenhill.reverse

/**
 * Reverses a list.
 *
 * ## Usage:
 * This function takes a list and returns a new list with the elements in reverse order.
 *
 * ### Example 1: Reversing a List of Integers
 * ```
 * val list = listOf(1, 2, 3, 4, 5)
 * val reversedList = reverse(list)
 * println(reversedList) // Output: [5, 4, 3, 2, 1]
 * ```
 *
 * ### Example 2: Reversing an Empty List
 * ```
 * val emptyList = listOf<Int>()
 * val reversedList = reverse(emptyList)
 * println(reversedList) // Output: []
 * ```
 *
 * @param list The list of integers to be reversed.
 * @return A new list with the elements in reverse order.
 */
fun <T> reverse(list: List<T>): List<T> = list.foldRight(emptyList()) { i, acc -> acc + i }
