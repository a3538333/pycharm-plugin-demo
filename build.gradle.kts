plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
    id("org.jetbrains.intellij") version "1.14.1"
}

group = "com.lovecaa"
version = "1.0.0"


repositories {
    mavenCentral()
    maven("https://plugins.jetbrains.com/maven")
    gradlePluginPortal()
}

dependencies {
//    implementation ("com.teamdev.jxbrowser:jxbrowser-swing:7.12.2")
}


// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    downloadSources.set(false)
    version.set("2023.1.2")
    type.set("PC") // Target IDE Platform
//    localPath.set("D:\\Soft\\JetBrains\\PyCharm 2022.3.3")
    plugins.set(listOf("PythonCore"))
}


tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("222")
        untilBuild.set("232.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}

