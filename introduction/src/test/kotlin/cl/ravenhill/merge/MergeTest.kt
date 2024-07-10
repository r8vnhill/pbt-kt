package cl.ravenhill.merge

import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class   MergeTest : FreeSpec({
    "Merging two lists" - {
        "should return a list with all elements sorted" - {
            withData(
                MergeData(listOf(), listOf(), listOf()),
                MergeData(listOf(1), listOf(), listOf(1)),
                MergeData(listOf(), listOf(1), listOf(1)),
                MergeData(listOf(1), listOf(2), listOf(1, 2)),
                MergeData(listOf(2), listOf(1), listOf(1, 2)),
                MergeData(listOf(1, 3), listOf(2, 4), listOf(1, 2, 3, 4)),
                MergeData(listOf(1, 2, 3), listOf(4, 5, 6), listOf(1, 2, 3, 4, 5, 6)),
                MergeData(listOf(4, 5, 6), listOf(1, 2, 3), listOf(1, 2, 3, 4, 5, 6)),
                MergeData(listOf(1, 2, 3), listOf(1, 2, 3), listOf(1, 1, 2, 2, 3, 3))
            ) { (list1, list2, expected) ->
                merge(list1, list2) shouldBe expected
            }
        }
    }
})

private data class MergeData<T>(
    val list1: List<T>,
    val list2: List<T>,
    val expected: List<T>
) where T : Comparable<T>
