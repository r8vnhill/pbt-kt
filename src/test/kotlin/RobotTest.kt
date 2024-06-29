import io.kotest.core.spec.style.FreeSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.*
import io.kotest.property.checkAll

class RobotTest : FreeSpec({
    "Robot" - {
        "should collect all positions" {
            checkAll(arbPath()) { path ->
                collect(path.size)
            }
        }
    }
})

enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

typealias Position = Pair<Int, Int>

fun arbPath(): Arb<List<Position>> = arbPath(
    0 to 0,
    listOf(),
    setOf(),
    emptySet()
)

fun arbPath(
    current: Position,
    acc: List<Position>,
    seen: Set<Position>,
    ignore: Set<Direction>
): Arb<List<Position>> = when (ignore.size) {
    Direction.entries.size -> Arb.constant(acc)

    else -> Arb
        .choose(
            1 to Arb.constant(acc),
            15 to increasePath(current, acc, seen, ignore)
        )
}

fun increasePath(
    current: Position,
    acc: List<Position>,
    seen: Set<Position>,
    ignore: Set<Direction>
): Arb<List<Position>> = Arb
    .element(Direction.entries.filter { it !in ignore })
    .flatMap { direction ->
        val newPosition = move(current, direction)
        if (newPosition in seen) {
            arbPath(current, acc, seen, ignore + direction)
        } else {
            arbPath(newPosition, acc + newPosition, seen + newPosition, emptySet())
        }
    }

fun move(current: Position, direction: Direction): Position = when (direction) {
    Direction.NORTH -> current.first to current.second + 1
    Direction.SOUTH -> current.first to current.second - 1
    Direction.EAST -> current.first + 1 to current.second
    Direction.WEST -> current.first - 1 to current.second
}
