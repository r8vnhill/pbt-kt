package cl.ravenhill.maps

import cl.ravenhill.biggest.biggestKey
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.checkAll

class MapTest : FreeSpec({
    "The biggest key in a map" - {
        "should be the same as the last key of a sorted map" {
            checkAll(arbIntStringMap()) { map ->
                collect("SIZES", map.size)
                biggestKey(map) shouldBe map.keys.sorted().lastOrNull()
            }
        }
    }
})

private fun arbIntStringMap(): Arb<Map<Int, String>> = arbitrary { (rng, seed) ->
    val size = rng.nextInt(1, 100)
    val map = mutableMapOf<Int, String>()
    while (map.size < size) {
        val key = rng.nextInt()
        val stringSize = rng.nextInt(1, 100)
        val value = List(stringSize) {
            rng.nextInt(0x0000, 0xFFFF).toChar()
        }.joinToString("")
        map[key] = value
    }
    map
}
