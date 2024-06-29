import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class StringLengthTest : FreeSpec({
    "The length of concatenated strings" - {
        "should be the sum of the lengths of the strings" {
            checkAll(Arb.string(), Arb.string()) { a, b ->
                (a + b).length shouldBe a.length + b.length
            }
        }
    }
})