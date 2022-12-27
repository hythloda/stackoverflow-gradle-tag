import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

tasks.withType<Test> {
    testLogging {
        // set options for log level LIFECYCLE
        events(TestLogEvent.FAILED,
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED,
            TestLogEvent.STANDARD_OUT)
        exceptionFormat(TestExceptionFormat.FULL)
        showExceptions(true)
        showCauses(true)
        showStackTraces(true)

        // set options for log level DEBUG and INFO
        debug {
            events(TestLogEvent.STARTED,
                TestLogEvent.FAILED,
                TestLogEvent.PASSED,
                TestLogEvent.SKIPPED,
                TestLogEvent.STANDARD_ERROR,
                TestLogEvent.STANDARD_OUT)
            exceptionFormat(TestExceptionFormat.FULL)
        }
        info.events = debug.events
        info.exceptionFormat = debug.exceptionFormat

        afterSuite { desc, result ->
            if (!desc.parent) { // will match the outermost suite
                val output = "Results: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} passed, ${result.failedTestCount} failed, ${result.skippedTestCount} skipped)"
                val startItem = "|  "
                val endItem = "  |"
                val repeatLength = startItem.length + output.length + endItem.length
                println("\n" + ("-" * repeatLength) + "\n" + startItem + output + endItem + "\n" + ("-" * repeatLength))
            }
        }
    }
}