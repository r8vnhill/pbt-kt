package cl.ravenhill.collections

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.map
import io.kotest.property.checkAll
import java.util.*

class QueueTest : FreeSpec({
    "A queue" - {
        "should have the correct size after enqueuing elements" {
            checkAll(arbQueue(Arb.int(), 0..100)) { queue ->
                queue.size shouldBe queue.toList().size
            }
        }

        "should follow FIFO order" {
            checkAll(arbQueue(Arb.int(), 1..100)) { queue ->
                val list = queue.toList()
                val dequeuedElements = mutableListOf<Int>()
                while (queue.isNotEmpty()) {
                    dequeuedElements.add(queue.poll())
                }
                dequeuedElements shouldContainExactly list
            }
        }

        "should be empty after dequeuing all elements" {
            checkAll(arbQueue(Arb.int(), 1..100)) { queue ->
                while (queue.isNotEmpty()) {
                    queue.poll()
                }
                queue.shouldBeEmpty()
            }
        }
    }
})

private fun <T> arbQueue(arb: Arb<T>, size: IntRange): Arb<Queue<T>> = Arb
    .list(arb, size)
    .map { list ->
        ArrayDeque(list)
    }
