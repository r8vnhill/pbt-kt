package cl.ravenhill.containsdigit

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.string

class ContainsDigitTest : FreeSpec({
    "A string with a digit should return true" {
        "abc1".containsDigit().shouldBeTrue()
    }
})

fun arbStringWithDigit() = Arb.string()
    .filter { it.any { it.isDigit() } }

fun arbStringWithoutDigit() = Arb.string()
    .filter { it.none { it.isDigit() } }