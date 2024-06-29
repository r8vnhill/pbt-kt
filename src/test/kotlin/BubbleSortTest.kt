import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

class BubbleSortTest : FreeSpec({
    "Bubble sort should be equal to insertion sort" {
        checkAll(Arb.list(Arb.int(), 1..100)) { list ->
            val bubbleSorted = bubbleSort(list)
            val insertionSorted = insertionSort(list)
            bubbleSorted shouldBe insertionSorted
        }
    }
})

fun <T> bubbleSort(list: List<T>): List<T> where T : Comparable<T> {
    val result = list.toMutableList()
    for (i in 0 until result.size) {
        for (j in 0 until result.size - 1) {
            if (result[j] > result[j + 1]) {
                val temp = result[j]
                result[j] = result[j + 1]
                result[j + 1] = temp
            }
        }
    }
    return result
}

fun <T> insertionSort(list: List<T>): List<T> where T : Comparable<T> {
    val result = list.toMutableList()
    for (i in 1..<result.size) {
        val key = result[i]
        var j = i - 1
        while (j >= 0 && result[j] > key) {
            result[j + 1] = result[j]
            j--
        }
        result[j + 1] = key
    }
    return result
}