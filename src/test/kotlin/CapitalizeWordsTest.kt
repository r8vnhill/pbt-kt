import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.*
import io.kotest.property.checkAll
import java.util.*

class CapitalizeWordsTest : FreeSpec({
    "Capitalize Words" - {
        "should maintain the number of words" {
            checkAll(Arb.string(0..100, Codepoint.az())) { text ->
                countWords(text) shouldBe countWords(text.capitalizeWords())
            }
        }

        "capitalization should be idempotent" {
            checkAll(Arb.string(0..100, Codepoint.az())) { text ->
                text.capitalizeWords().capitalizeWords() shouldBe
                        text.capitalizeWords()
            }
        }

        "only the first letter of each word should be uppercase" {
            checkAll(Arb.string(1..100, Codepoint.az())) { text ->
                val capitalized = text.capitalizeWords()
                capitalized.split(" ").forEach { word ->
                    word[0].isUpperCase().shouldBeTrue()
                    word.drop(1).all { it.isLowerCase() }.shouldBeTrue()
                }
            }
        }
    }
})

private fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") { str ->
        str.lowercase().replaceFirstChar {
            it.uppercase()
        }
    }

fun countWords(text: String) =
    text.split("""\s+""".toRegex()).size