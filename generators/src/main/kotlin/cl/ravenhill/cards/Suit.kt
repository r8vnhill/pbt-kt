package cl.ravenhill.cards

/**
 * Enum representing the suits of playing cards.
 *
 * ## Usage:
 * This enum class defines the possible suits of playing cards: CLUBS, DIAMONDS, HEARTS, and SPADES.
 *
 * ### Example 1: Using the Suit Enum
 * ```
 * val suit = Suit.CLUBS
 * println(suit) // Output: CLUBS
 *
 * val allSuits = Suit.entries
 * println(allSuits.joinToString()) // Output: CLUBS, DIAMONDS, HEARTS, SPADES
 * ```
 *
 * @enum Suit The enum values represent different card suits.
 * @property CLUBS The suit for Clubs.
 * @property DIAMONDS The suit for Diamonds.
 * @property HEARTS The suit for Hearts.
 * @property SPADES The suit for Spades.
 */
enum class Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES
}
