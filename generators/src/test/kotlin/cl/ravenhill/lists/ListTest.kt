package cl.ravenhill.lists

import cl.ravenhill.biggest.biggest
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.checkAll

class ListTest : FreeSpec({
    "Biggest element in a list" - {
        "should return the biggest number on a non-empty list" {
            checkAll(arbIntList()) { list ->
                collect("SIZES", list.size)
                biggest(list) shouldBe list.sorted().lastOrNull()
            }
        }
    }
})

fun arbIntList(): Arb<List<Int>> = arbitrary { (rng, seed) ->
    val size = rng.nextInt(1, 100)
    val list = List(size) { rng.nextInt() }
    list
}
