import java.util.*

plugins {
    kotlin("jvm")
    id("io.gitlab.arturbosch.detekt")
}

allprojects {
    group = "pbt-kt"
    version = extra["pbt-kt.version"] as String
}

subprojects {
    repositories {
        mavenCentral()
    }
}
