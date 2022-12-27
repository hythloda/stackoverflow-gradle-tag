buildscript {
    ext["kotlin_version"] = "1.1.2-2"
    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:2.3.1")
        classpath("com.google.gms:google-services:3.0.0")
        classpath("com.getkeepsafe.dexcount:dexcount-gradle-plugin:0.6.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        jcenter()
        maven(url = "https://jitpack.io")
    }
}

ext["googlePlayServicesVersion"] = "10.2.0"
ext["supportLibraryVersion"] = "25.3.1"

task("clean") {
    delete(rootProject.buildDir)
}
