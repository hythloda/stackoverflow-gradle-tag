tasks.register<Wrapper>("wrapper") {
    gradleVersion = "4.1"
}

//not sure if this works
tasks {
    wrapper("wrapper", Wrapper::class)
    gradleVersion = "4.1"
}

//not sure if this is better
tasks {
    wrapper("wrapper") {
        type = Wrapper::class
        gradleVersion = "4.1"
    }
}
