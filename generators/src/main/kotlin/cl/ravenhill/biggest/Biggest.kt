package cl.ravenhill.biggest

/**
 * Finds the biggest (maximum) integer in a list.
 *
 * ## Usage:
 * This function takes a list of integers and returns the largest integer in the list. If the list is empty, it returns
 * `Int.MIN_VALUE`.
 *
 * ### Example 1: Finding the Biggest Integer in a List
 * ```
 * val list = listOf(3, 1, 4, 1, 5, 9)
 * val max = biggest(list)
 * println(max) // Output: 9
 * ```
 *
 * ### Example 2: Handling an Empty List
 * ```
 * val emptyList = listOf<Int>()
 * val max = biggest(emptyList)
 * println(max) // Output: -2147483648 (Int.MIN_VALUE)
 * ```
 *
 * @param list The list of integers to be checked.
 * @return The biggest (maximum) integer in the list, or `Int.MIN_VALUE` if the list is empty.
 */
fun biggest(list: List<Int>) =
    list.fold(Int.MIN_VALUE) { acc, i ->
        if (i > acc) i else acc
    }
