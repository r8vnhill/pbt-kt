package cl.ravenhill.encode

/**
 * Encodes a text using the Caesar cipher with a given shift.
 *
 * ## Usage:
 * This function takes a text and a shift value, returning the text encoded using the Caesar cipher.
 *
 * ### Example 1: Encoding a lowercase text
 * ```
 * val encodedText = cesarEncode("hello", 3)
 * println(encodedText) // Output: khoor
 * ```
 * ### Example 2: Encoding an uppercase text
 * ```
 * val encodedText = cesarEncode("HELLO", 3)
 * println(encodedText) // Output: KHOOR
 * ```
 * ### Example 3: Encoding a mixed text
 * ```
 * val encodedText = cesarEncode("Hello, World!", 3)
 * println(encodedText) // Output: Khoor, Zruog!
 * ```
 * @param text The text to encode.
 * @param shift The shift value for the Caesar cipher.
 * @return The encoded text.
 */
fun cesarEncode(text: String, shift: Int) = text.map { c ->
    cesarEncodeChar(c, shift)
}.joinToString("")

/**
 * Encodes a single character using the Caesar cipher with a given shift.
 *
 * This function handles both uppercase and lowercase letters, preserving non-alphabetic characters as they are.
 *
 * @param c The character to encode.
 * @param shift The shift value for the Caesar cipher.
 * @return The encoded character.
 */
private fun cesarEncodeChar(c: Char, shift: Int) = when {
    c.isLowerCase() -> 'a' + (c - 'a' + shift) % 26
    c.isUpperCase() -> 'A' + (c - 'A' + shift) % 26
    else -> c
}
