import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.assume
import io.kotest.property.checkAll

class NonEmptyListTest : FreeSpec({
    "NonEmptyList" - {
        "should never be empty (filter)" {
            checkAll(arbNonEmptyList(Arb.int())) { list ->
                list.shouldNotBeEmpty()
            }
        }

        "should never be empty (assume)" {
            checkAll(Arb.list(Arb.int())) { list ->
                assume {
                    list.size shouldBeGreaterThan 0
                }
                list.shouldNotBeEmpty()
            }
        }
    }
})

fun <T> arbNonEmptyList(arb: Arb<T>): Arb<List<T>> =
    Arb.list(arb)
        .filter { it.isNotEmpty() }