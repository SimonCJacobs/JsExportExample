plugins {
    kotlin("multiplatform") version "1.7.20"
}

repositories {
    mavenCentral()
}

kotlin {
    js(org.jetbrains.kotlin.gradle.plugin.KotlinJsCompilerType.IR) {
        nodejs {
            binaries.executable()
        }
    }
    jvm()
}

tasks.register<JavaExec>("jvmRun") {
    mainClass.set("MainKt")
    classpath = kotlin.jvm().compilations.first().let { it.output.allOutputs + it.runtimeDependencyFiles }
}