package cl.ravenhill.cards

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.property.Arb
import io.kotest.property.arbitrary.element
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.pair
import io.kotest.property.checkAll

class CardsTest : FreeSpec({
    "A hand of cards" - {
        "should contain valid suits and ranks" {
            checkAll(arbHand()) { hand ->
                collect("SIZES", hand.size)
                hand.forEach { (suit, rank) ->
                    Suit.entries shouldContain suit
                    Rank.entries shouldContain rank
                }
            }
        }
    }
})

private fun arbCard() = Arb.pair(
    Arb.element(Suit.entries.toList()),
    Arb.element(Rank.entries.toList())
)

private fun arbHand() = Arb.list(arbCard(), 1..10)

// Better implementation of the above code
//private fun arbCard() = Arb.pair(
//    Arb.enum<Suit>(),
//    Arb.enum<Rank>()
//)
