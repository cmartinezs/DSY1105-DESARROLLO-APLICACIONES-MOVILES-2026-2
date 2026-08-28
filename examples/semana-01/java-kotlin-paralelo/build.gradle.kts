plugins {
    java
    kotlin("jvm") version "2.2.0"
}

group = "cl.duoc.dsy1105"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    jvmToolchain(21)
}
