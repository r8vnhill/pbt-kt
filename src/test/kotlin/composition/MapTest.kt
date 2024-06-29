package composition

import io.kotest.core.spec.style.FreeSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.triple

class MapTest : FreeSpec({

})

fun <K, V> arb(keyVal: Arb<Pair<K, V>>): Arb<Map<K, V>> = Arb.map(keyVal)
