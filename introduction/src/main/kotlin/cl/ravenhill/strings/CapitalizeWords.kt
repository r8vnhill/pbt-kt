package cl.ravenhill.strings

/**
 * Capitalizes the first letter of each word in the string.
 *
 * ## Usage:
 * This extension function takes a string and returns a new string with the first letter of each word capitalized. All
 * other letters in each word are converted to lowercase.
 *
 * ### Example 1: Capitalizing Words in a Sentence
 * ```
 * val sentence = "hello world from kotlin"
 * val capitalized = sentence.capitalizeWords()
 * println(capitalized) // Output: "Hello World From Kotlin"
 * ```
 *
 * @receiver The original string to be transformed.
 * @return A new string with the first letter of each word capitalized.
 */
fun String.capitalizeWords() = split(" ").joinToString(" ") { str ->
    str.lowercase().replaceFirstChar { it.uppercase() }
}
