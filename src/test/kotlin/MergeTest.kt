import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class MergeTest : FreeSpec({
    "Merge" - {
        "should merge two lists" - {
            withData(
                MergeData(listOf(), listOf(), listOf()),
                MergeData(listOf(1), listOf(), listOf(1)),
                MergeData(listOf(), listOf(1), listOf(1)),
                MergeData(listOf(1), listOf(2), listOf(1, 2)),
                MergeData(listOf(2), listOf(1), listOf(1, 2)),
                MergeData(listOf(1, 3), listOf(2, 4), listOf(1, 2, 3, 4)),
                MergeData(listOf(1, 2), listOf(1, 2), listOf(1, 1, 2, 2)),
                MergeData(listOf(2, 1), listOf(1, 2), listOf(1, 1, 2, 2)),
            ) { (list1, list2, expected) ->
                val actual = merge(list1, list2)
                actual shouldBe expected
            }
        }
    }
})

private data class MergeData(
    val list1: List<Int>,
    val list2: List<Int>,
    val expected: List<Int>,
)

fun merge(list1: List<Int>, list2: List<Int>): List<Int> {
    TODO("Not yet implemented")
}