import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

class ReverseTest : FreeSpec({
    "Reverse" - {
        "should reverse a list" {
            checkAll(
                Arb.list(Arb.int()),
                Arb.list(Arb.int())
            ) { list1, list2 ->
                reverse(list1 + list2) shouldBe
                        reverse(list2) + reverse(list1)
            }
        }
    }
})

fun reverse(ints: List<Int>): List<Int> {
    TODO("Not yet implemented")
}
