package cl.ravenhill.merge

/**
 * Merges two sorted lists into a single sorted list.
 *
 * ## Usage:
 * This function takes two sorted lists of comparable elements and merges them into a single sorted list. It maintains
 * the order of elements from both input lists.
 *
 * ### Example 1: Merging Two Sorted Lists of Integers
 * ```
 * val list1 = listOf(1, 3, 5)
 * val list2 = listOf(2, 4, 6)
 * val mergedList = merge(list1, list2)
 * println(mergedList) // Output: [1, 2, 3, 4, 5, 6]
 * ```
 *
 * ### Example 2: Merging Two Sorted Lists of Strings
 * ```
 * val list1 = listOf("apple", "banana")
 * val list2 = listOf("apricot", "blueberry")
 * val mergedList = merge(list1, list2)
 * println(mergedList) // Output: [apple, apricot, banana, blueberry]
 * ```
 *
 * @param T The type of elements in the lists, which must be comparable.
 * @param list1 The first sorted list to be merged.
 * @param list2 The second sorted list to be merged.
 * @return A new list containing all elements from both input lists, sorted.
 */
fun <T> merge(list1: List<T>, list2: List<T>): List<T> where T : Comparable<T> {
    val result = mutableListOf<T>()
    var i = 0
    var j = 0

    // Merging the two lists by comparing elements
    while (i < list1.size && j < list2.size) {
        if (list1[i] < list2[j]) {
            result += list1[i]
            i++
        } else {
            result += list2[j]
            j++
        }
    }

    // Add remaining elements from list1, if any
    result.addAll(list1.subList(i, list1.size))

    // Add remaining elements from list2, if any
    result.addAll(list2.subList(j, list2.size))

    return result
}
