package cl.ravenhill.last

import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LastTest : FreeSpec({
    "The last element of a list" - {
        "should be the last element" - {
            withData(
                nameFn = { (_, input) -> "last($input)" },
                3 to listOf(1, 2, 3),
                2 to listOf(1, 2),
                1 to listOf(1)
            ) { (expected, input) ->
                last(input) shouldBe expected
            }
        }
    }
})