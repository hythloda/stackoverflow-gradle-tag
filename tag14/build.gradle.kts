plugins {
  id("java")
}

tasks.withType<Test> {
  filter {
    // specific test method
    includeTestsMatching("org.gradle.SomeTest.someSpecificFeature")

    // specific test method, use wildcard for packages
    includeTestsMatching("*SomeTest.someSpecificFeature")

    // specific test class
    includeTestsMatching("org.gradle.SomeTest")

    // specific test class, wildcard for packages
    includeTestsMatching("*.SomeTest")

    // all classes in package, recursively
    includeTestsMatching("com.gradle.tooling.*")

    // all integration tests, by naming convention
    includeTestsMatching("*IntegTest")

    // only ui tests from integration tests, by some naming convention
    includeTestsMatching("*IntegTest*ui")
  }
}
