package cl.ravenhill.levenshtein

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldNotBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.string
import io.kotest.property.assume
import io.kotest.property.checkAll

class LevenshteinTest : FreeSpec({
    "The levenshtein distance between two different strings should be greater than 0" {
        checkAll(Arb.string(), Arb.string()) { a, b ->
            assume {
                a shouldNotBe b
            }
            a levenshtein b shouldNotBe 0
        }
    }
})
