package transform

import io.kotest.property.Arb
import io.kotest.property.arbitrary.*

class LibraryTest {

}

data class Book(val title: String, val author: String, val isbn: String)

fun arbIsbn(): Arb<String> = arbitrary { (rng, seed) ->
    val digits = mutableListOf<Int>()
    for (i in 0..<13) {
        digits.add(rng.nextInt(0, 9))
    }
    digits.joinToString("")
}

fun arbBook(): Arb<Book> = Arb.string().flatMap { title ->
    Arb.string().flatMap { author ->
        arbIsbn().map { isbn ->
            Book(title, author, isbn)
        }
    }
}