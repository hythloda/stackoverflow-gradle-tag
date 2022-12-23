tasks.withType<JavaCompile>().configure {
   options.fork = true
   options.forkOptions.executable = "/path_to_javac"
}
