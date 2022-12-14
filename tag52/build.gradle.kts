plugins {
    id("com.android.application")
}

android {
    compileSdkVersion(19)
    buildToolsVersion("20.0.0")

    defaultConfig {
        applicationId = "org.example"
        minSdkVersion(14)
        targetSdkVersion(19)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
    }
}
