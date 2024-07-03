package cl.ravenhill.transformlist

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.double
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

class TransformListTest : FreeSpec({
    "Doubling and halving a list should return the original list" {
        checkAll(Arb.list(Arb.double(-100.0, 100.0))) { list ->
            val doubled = list.doubled()
            val halved = doubled.halved()
            halved shouldBe list
        }
    }
})