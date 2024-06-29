import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

class BinarySearchTest : FreeSpec({
    "Binary search should be equivalent to sequential search" {
        checkAll(Arb.list(Arb.int()), Arb.int()) { list, element ->
            val sortedList = list.sorted()
            val sequential = sequentialSearch(sortedList, element)
            val binary = binarySearch(sortedList, element)
            binary shouldBe sequential
        }
    }
})

fun <T> sequentialSearch(list: List<T>, element: T): Boolean where T : Comparable<T> {
    for (current in list) {
        if (current == element) {
            return true
        }
    }
    return false
}

fun <T> binarySearch(list: List<T>, element: T): Boolean where T : Comparable<T> {
    var left = 0
    var right = list.size - 1
    while (left <= right) {
        val middle = (left + right) / 2
        val current = list[middle]
        when {
            current == element -> return true
            current < element -> left = middle + 1
            else -> right = middle - 1
        }
    }
    return false
}