package cl.ravenhill.encode

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class EncodeDecodeTest : FreeSpec({
    "Encoding and decoding an input should return the original input" {
        checkAll(Arb.string(), Arb.int(1..25)) { text, shift ->
            val encoded = cesarEncode(text, shift)
            val decoded = cesarDecode(encoded, shift)
            decoded shouldBe text
        }
    }
})
