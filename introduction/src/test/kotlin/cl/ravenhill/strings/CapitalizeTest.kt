package cl.ravenhill.strings

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.Codepoint
import io.kotest.property.arbitrary.az
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class CapitalizeTest : FreeSpec({
    "Capitalization" - {
        "should maintain the number of words" {
            checkAll(Arb.string(0..100, Codepoint.az())) { s ->
                countWords(s) shouldBe countWords(s.capitalizeWords())
            }
        }

        "should be idempotent" {
            checkAll(Arb.string(0..100, Codepoint.az())) { s ->
                s.capitalizeWords().capitalizeWords() shouldBe s.capitalizeWords()
            }
        }

        "only the first letter of each word should be uppercase" {
            checkAll(Arb.string(1..100, Codepoint.az())) { s ->
                val capitalized = s.capitalizeWords()
                capitalized.split(" ").forEach { word ->
                    word.first().isUpperCase() shouldBe true
                    word.drop(1).all { it.isLowerCase() }.shouldBeTrue()
                }
            }
        }
    }
})

private fun countWords(s: String) = s.split(" ").count { it.isNotBlank() }
