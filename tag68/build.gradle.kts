android {
    // other properties

    defaultConfig {
        ...

        // Enabling multidex support.
        multiDexEnabled = true
    }
    ...
}

dependencies {
    implementation("androidx.multidex:multidex:2.0.1")  // with androidx libraries
    // implementation("com.android.support:multidex:1.0.3")  // with support libraries
}
