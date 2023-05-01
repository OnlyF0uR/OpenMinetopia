plugins {
    `java-library`
}

group = "nl.onlyfour"
version = "0.1.0-SNAPSHOT"
description = "The most universal open-source Minetopia plugin"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
    maven("https://maven.enginehub.org/repo/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    implementation("com.zaxxer:HikariCP:5.0.1") // Shade

//    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
//    compileOnly("com.sk89q.worldguard:worldguard-bukkit:7.1.0-SNAPSHOT")
//    compileOnly("com.sk89q.worldedit:worldedit-bukkit:7.3.0-SNAPSHOT")
}

tasks {
    assemble {
//        dependsOn(reobfJar)
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name()
        val props = mapOf(
                "name" to project.name,
                "version" to project.version,
                "description" to project.description,
                "apiVersion" to "1.19"
        )
        inputs.properties(props)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}