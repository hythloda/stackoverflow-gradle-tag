plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    compile("com.google.guava:guava:12.0")
}

tasks.register("showMeCache") {
    doLast {
        configurations["compileClasspath"].forEach { println(it) }
    }
}
