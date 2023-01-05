plugins {
    id("java-library")
    `maven-publish`
    id("io.freefair.lombok") version "6.5.1" apply (false)
}



subprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "io.freefair.lombok")

    version = "1.0.0"

    repositories {
        mavenCentral()
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(11))
        }
        withSourcesJar()
    }
    dependencies {
        compileOnly("org.jetbrains:annotations:23.0.0")
    }

    tasks.compileJava {
        options.compilerArgs.add("-parameters");
    }

    val mavenArtifactId = "minestom-event" + project.path.replace(":", "-");

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "ru.spliterash"
                artifactId = mavenArtifactId

                from(components["java"])
            }
        }
        repositories {
            maven {
                name = "nexus"
                url = uri("https://repo.spliterash.ru/minestom-event")
                credentials {
                    username = findProperty("SPLITERASH_NEXUS_USR")?.toString()
                    password = findProperty("SPLITERASH_NEXUS_PSW")?.toString()
                }
            }
        }
    }
}

tasks {
    jar { enabled = false }
}

configure(subprojects - project(":core")) {
    dependencies {
        api(project(":core"))
    }
}