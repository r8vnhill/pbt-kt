package cl.ravenhill.last

/**
 * Returns the last element of a list of integers.
 *
 * ## Usage:
 * This function takes a list of integers and returns the last element in the list.
 *
 * ### Example 1: Getting the Last Element from a Non-Empty List
 * ```
 * val numbers = listOf(1, 2, 3, 4, 5)
 * val lastNumber = last(numbers)
 * println(lastNumber) // Output: 5
 * ```
 * ### Example 2: Handling an Empty List
 * ```
 * val numbers = emptyList<Int>()
 * try {
 *     val lastNumber = last(numbers)
 * } catch (e: IndexOutOfBoundsException) {
 *     println("List is empty")
 * }
 * // Output: List is empty
 * ```
 * @param list The list of integers from which to get the last element.
 * @return The last element of the list.
 * @throws IndexOutOfBoundsException if the list is empty.
 */
fun last(list: List<Int>) = list[list.size - 1]
