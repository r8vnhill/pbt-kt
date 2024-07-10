package cl.ravenhill.merge

fun <T> merge(list1: List<T>, list2: List<T>): List<T> where T : Comparable<T> {
    val result = mutableListOf<T>()
    var i = 0
    var j = 0

    // Merging the two lists by comparing elements
    while (i < list1.size && j < list2.size) {
        if (list1[i] < list2[j]) {
            result += list1[i]
            i++
        } else {
            result += list2[j]
            j++
        }
    }

    // Add remaining elements from list1, if any
    result.addAll(list1.subList(i, list1.size))

    // Add remaining elements from list2, if any
    result.addAll(list2.subList(j, list2.size))

    return result
}
