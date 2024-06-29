package composition

import io.kotest.core.spec.style.FreeSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.enum
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.pair
import io.kotest.property.arbitrary.string

class TeamTest : FreeSpec({

})

enum class Role {
    LEADER,
    DEVELOPER,
    TESTER
}

fun arbMember(): Arb<Pair<Role, String>> = Arb.pair(
    Arb.enum<Role>(),
    Arb.string()
)

fun arbTeam(): Arb<List<Pair<Role, String>>> = Arb.list(
    arbMember(),
    3..6
)