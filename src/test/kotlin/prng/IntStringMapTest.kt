package prng

import io.kotest.core.spec.style.FreeSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.checkAll
import kotlin.random.nextInt

class IntStringMapTest : FreeSpec({
    "IntStringMap" - {
        "should have a uniform distribution" {
            checkAll(arbIntStringMap()) { map ->
                collect(map.size)
            }
        }
    }
})

fun arbIntStringMap(): Arb<Map<Int, String>> = arbitrary { (rng, seed) ->
    val size = rng.nextInt(1..100)
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