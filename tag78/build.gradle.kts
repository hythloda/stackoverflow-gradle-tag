plugins {
    apply("maven")
}

group = "foo"
version = "1.0"

repositories {
    mavenLocal()
}

dependencies {
    compile("foo:sdk:1.0")
}
