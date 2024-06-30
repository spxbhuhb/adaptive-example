
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.adaptive)
}

version = "2024.06.04-SNAPSHOT"

adaptive {
//    pluginDebug = true
//    pluginLogDir = projectDir.toPath()
    resources {
        publicResClass = true
    }
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    jvm()

    js(IR) {
        browser()
        binaries.library()
    }

    if (libs.versions.ios.support.get() != "none") {
        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "Shared"
                isStatic = true
                // see https://youtrack.jetbrains.com/issue/KT-56152
                binaryOption("bundleId", "${project.group}.${project.name}")
                binaryOption("bundleVersion", version.toString().substringBefore('-'))
            }
        }
    }

    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.adaptive.core)
                api(libs.adaptive.lib.ktor)
                api(libs.adaptive.lib.sandbox)
                api(libs.adaptive.ui.common)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.appcompat)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "hu.simplexion.adaptive.example.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
