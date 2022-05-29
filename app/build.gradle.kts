plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"

    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.github.pengrad:java-telegram-bot-api:${project.property("telegramBotApiVersion")}")
    implementation("com.google.code.gson:gson:${project.property("gsonVersion")}")
}

application {
    mainClass.set("descriptobot.AppKt")
}
