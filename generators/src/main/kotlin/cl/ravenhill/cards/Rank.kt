package cl.ravenhill.cards

/**
 * Enum representing the ranks of playing cards.
 *
 * ## Usage:
 * This enum class defines the possible ranks of playing cards, from ACE to KING.
 *
 * ### Example 1: Using the Rank Enum
 * ```
 * val rank = Rank.ACE
 * println(rank) // Output: ACE
 *
 * val allRanks = Rank.entries
 * println(allRanks.joinToString())
 * // Output: ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
 * ```
 *
 * @enum Rank The enum values represent different card ranks.
 * @property ACE The rank for Ace.
 * @property TWO The rank for Two.
 * @property THREE The rank for Three.
 * @property FOUR The rank for Four.
 * @property FIVE The rank for Five.
 * @property SIX The rank for Six.
 * @property SEVEN The rank for Seven.
 * @property EIGHT The rank for Eight.
 * @property NINE The rank for Nine.
 * @property TEN The rank for Ten.
 * @property JACK The rank for Jack.
 * @property QUEEN The rank for Queen.
 * @property KING The rank for King.
 */
enum class Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}
