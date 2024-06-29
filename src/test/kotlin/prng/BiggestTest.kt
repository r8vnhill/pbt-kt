package prng

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.arbitrary.element
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.pair
import io.kotest.property.checkAll
import kotlin.random.nextInt

class BiggestTest : FreeSpec({
    "Biggest" - {
        "should return the biggest number on a non-empty list" {
            checkAll(arbIntList()) { list ->
                val biggest = biggest(list)
                biggest shouldBe list.sorted().last()
            }
        }
    }
})

fun biggest(list: List<Int>): Int {
    var biggest = Int.MIN_VALUE
    for (number in list) {
        if (number > biggest) {
            biggest = number
        }
    }
    return biggest
}

fun arbIntList(): Arb<List<Int>> = arbitrary { (rng, seed) ->
    val size = rng.nextInt(1, 100)
    val list = List(size) { rng.nextInt() }
    list
}

enum class Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

enum class Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

fun arbCard(): Arb<Pair<Suit, Rank>> = Arb.pair(
    Arb.element(Suit.entries.toList()),
    Arb.element(Rank.entries.toList())
)

fun arbHand(card: Arb<Pair<Suit, Rank>>): Arb<List<Pair<Suit, Rank>>> =
    Arb.list(card)
