package cl.ravenhill.biggest

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

class BiggestTest : FreeSpec({
    "The biggest element in a list" - {
        "should be the same as the last element of a sorted list" - {
            checkAll(Arb.list(Arb.int())) { list ->
                biggest(list) shouldBe list.sorted().lastOrNull()
            }
        }
    }
})
