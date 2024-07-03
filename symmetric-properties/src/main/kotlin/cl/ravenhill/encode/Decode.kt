package cl.ravenhill.encode

/**
 * Decodes a text encoded using the Caesar cipher with a given shift.
 *
 * ## Usage:
 * This function takes a text that has been encoded using the Caesar cipher and a shift value, returning the decoded
 * text.
 *
 * ### Example 1: Decoding a lowercase text
 * ```
 * val encodedText = cesarEncode("hello", 3)
 * val decodedText = cesarDecode(encodedText, 3)
 * println(decodedText) // Output: hello
 * ```
 * ### Example 2: Decoding an uppercase text
 * ```
 * val encodedText = cesarEncode("HELLO", 3)
 * val decodedText = cesarDecode(encodedText, 3)
 * println(decodedText) // Output: HELLO
 * ```
 * ### Example 3: Decoding a mixed text
 * ```
 * val encodedText = cesarEncode("Hello, World!", 3)
 * val decodedText = cesarDecode(encodedText, 3)
 * println(decodedText) // Output: Hello, World!
 * ```
 * @param text The text to decode.
 * @param shift The shift value that was used for encoding with the Caesar cipher.
 * @return The decoded text.
 */
fun cesarDecode(text: String, shift: Int) =
    cesarEncode(text, 26 - shift)
