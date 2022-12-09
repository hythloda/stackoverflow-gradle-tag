buildscript {
    repositories {
        maven {
            url = uri("https://jitpack.io")
            url = uri("https://maven.fabric.io/public")
        }
    }

    dependencies {
        classpath("io.fabric.tools:gradle:1.+")
    }
}

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("io.fabric")
    id("kotlin-android-extensions")
}

repositories {
    maven { url = uri("https://maven.fabric.io/public") }
    mavenCentral()
}

android {
    compileSdkVersion(25)
    buildToolsVersion = "25.0.2"
    useLibrary("org.apache.http.legacy")

    lintOptions {
        checkReleaseBuilds = false
        abortOnError = false
    }

    defaultConfig {
        applicationId = "uxx.xx.xxe"
        minSdkVersion(18)
        targetSdkVersion(25)
        versionCode = 17
        versionName = "0.1.14"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            shrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            ext["enableCrashlytics"] = false
            isDebuggable = true
            isMinifyEnabled = true
            shrinkResources = true

            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    sourceSets {
        getByName("main") {
            jniLibs.srcDirs = listOf("libs")
            assets.srcDirs = listOf("src/main/assets", "src/main/assets/")
            res.srcDirs = listOf("src/main/res", "src/main/assets/fonts")
        }
    }

    dexOptions {
        isJumboMode = true
        javaMaxHeapSize = "4g"

    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/NOTICE")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/ECLIPSE_.SF")
        exclude("META-INF/ECLIPSE_.RSA")
    }
}


dependencies {
    compile(fileTree(include = ["*.jar"], dir = "libs"))

    compile("com.android.support:cardview-v7:${rootProject.supportLibraryVersion}")
    compile("com.google.android.gms:play-services-ads:${rootProject.googlePlayServicesVersion}")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version")
    compile("org.igniterealtime.smack:smack-android-extensions:4.1.9")
    compile("org.igniterealtime.smack:smack-tcp:4.1.9")
    compile("org.igniterealtime.smack:smack-experimental:4.1.9")
    testCompile("junit:junit:4.12")
}

apply(plugin = "com.google.gms.google-services")
apply(plugin = "com.getkeepsafe.dexcount")
