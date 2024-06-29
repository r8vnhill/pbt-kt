plugins {
    kotlin("jvm") version "2.0.0"
    id("io.gitlab.arturbosch.detekt") version "1.23.6"
}


val kotestVersion = "5.9.0"
val kotlinxDatetimeVersion = "0.4.1"

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")
}

application {
    mainClass.set("cl.ravenhill.EchoKt")
}

launch4j {
    mainClassName = application.mainClass.get()
}

tasks.register<Jar>("fatJar") {
    // Configura el nombre del archivo JAR resultante con el sufijo "fat"
    archiveClassifier.set("fat")

    // Establece la estrategia de manejo de duplicados a EXCLUDE (excluir archivos duplicados)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // Configura el manifiesto del JAR, estableciendo la clase principal que contiene el método main
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }

    // Añade la salida del conjunto de fuentes principal al JAR
    from(sourceSets.main.get().output)

    // Establece que esta tarea depende de las clases en el classpath de tiempo de ejecución
    dependsOn(configurations.runtimeClasspath)

    // Añade las dependencias del classpath de tiempo de ejecución al JAR
    from({
        configurations.runtimeClasspath
            .get() // Obtiene las dependencias de tiempo de ejecución
            .filter { it.name.endsWith("jar") } // Filtra solo los archivos JAR
            .map { project.zipTree(it) } // Descomprime cada JAR para incluir su contenido
    })
}


tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}