tasks.register<Jar>("sourcesJar") {
    dependsOn(tasks.named("classes"))
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

tasks.register<Jar>("javadocJar") {
    dependsOn(tasks.named("javadoc"))
    classifier = "javadoc"
    from(javadoc.destinationDir)
}

artifacts {
    add(tasks.named("sourcesJar"))
    add(tasks.named("javadocJar"))
}