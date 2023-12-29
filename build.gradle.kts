// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version = "1.4.1"
    val appcompat = "1.5.0"
    val kotlinVersion = "1.8.0"
    // Hilt
    val hilt_version = "2.44"


    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:$hilt_version")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

    }
    repositories {
        mavenCentral()
        google()
    }
}

plugins {
    id("com.android.application") version "8.1.3" apply false
    id("com.android.library") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}