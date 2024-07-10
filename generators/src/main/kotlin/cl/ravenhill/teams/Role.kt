package cl.ravenhill.teams

/**
 * Enum representing different roles in a software development team.
 *
 * ## Usage:
 * This enum class defines the possible roles in a software development team: `LEADER`, `DEVELOPER`, and `TESTER`.
 *
 * ### Example 1: Using the Role Enum
 * ```
 * val role = Role.DEVELOPER
 * println(role) // Output: DEVELOPER
 *
 * val allRoles = Role.entries
 * println(allRoles.joinToString()) // Output: LEADER, DEVELOPER, TESTER
 * ```
 *
 * @enum Role The enum values represent different team roles.
 * @property LEADER The role of a team leader.
 * @property DEVELOPER The role of a software developer.
 * @property TESTER The role of a software tester.
 */
enum class Role {
    LEADER, DEVELOPER, TESTER
}
