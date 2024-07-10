package cl.ravenhill.biggest

/**
 * Finds the biggest (maximum) key in a map.
 *
 * ## Usage:
 * This function takes a map with integer keys and string values, and returns the largest key in the map.
 *
 * ### Example 1: Finding the Biggest Key in a Map
 * ```
 * val map = mapOf(1 to "one", 3 to "three", 2 to "two")
 * val maxKey = biggestKey(map)
 * println(maxKey) // Output: 3
 * ```
 *
 * @param map The map with integer keys and string values.
 * @return The biggest (maximum) key in the map.
 */
fun biggestKey(map: Map<Int, String>): Int = biggest(map.keys.toList())
