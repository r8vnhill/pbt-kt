val kotestVersion = extra["kotest.version"] as String

plugins {
    id("io.gitlab.arturbosch.detekt")
    kotlin("jvm")
}

dependencies {
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-framework-datatest:$kotestVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
