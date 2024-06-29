import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.flatMap
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.map
import io.kotest.property.checkAll
import kotlin.collections.ArrayDeque

class QueueTest : FreeSpec({
    "Queue" - {
        "should return the first element on a non-empty queue" {
            checkAll(arbQueue(Arb.int(), 1..100)) { queue ->
                val first = queue.first()
                first shouldBe queue.removeFirst()
            }
        }
    }

    "Two queues created with the same size should have the same size" {
        checkAll(arbQueue(Arb.int(), 1..100) compose { q: ArrayDeque<Int> ->
            arbQueue(Arb.int(), q.size..q.size)
        }) { (queue1, queue2) ->
            queue1.size shouldBe queue2.size
        }
    }
})

fun <T> arbQueue(arb: Arb<T>, size: IntRange): Arb<ArrayDeque<T>> =
    Arb.list(arb, size)
        .map { list ->
            ArrayDeque(list)
        }

infix fun <A, B> Arb<A>.compose(f: (A) -> Arb<B>): Arb<Pair<A, B>> =
    this.flatMap { a: A ->
        f(a).map { b: B ->
            a to b
        }
    }
