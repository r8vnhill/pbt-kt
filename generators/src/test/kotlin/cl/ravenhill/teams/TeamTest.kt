package cl.ravenhill.teams

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.property.Arb
import io.kotest.property.arbitrary.element
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

class TeamTest : FreeSpec({
    "A team" - {
        "should contain valid roles" {
            checkAll(arbTeam()) { team ->
                team.forEach { role ->
                    Role.entries shouldContain role
                }
            }
        }
    }
})

private fun arbMember() = Arb.element(Role.entries.toList())

private fun arbTeam() = Arb.list(arbMember(), 1..10)

// Better implementation of the above code
//private fun arbMember() = Arb.enum<Role>()
