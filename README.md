A minimal example based on Spring Initializr, showing that `ch.qos.logback.core.util.ExecutorServiceUtil#makeThreadFactory` falls back to `Executors.defaultThreadFactory()` in a non-Jigsaw app.

To reproduce you can either:
1. Run `./gradlew test` and observe the exception (`ReflectionTest` has the same code as `ch.qos.logback.core.util.ExecutorServiceUtil#makeThreadFactory`, using Logback 1.4.14)
2. Or debug the `DemoApplication` and set a breakpoint in `ch.qos.logback.core.util.ExecutorServiceUtil#makeThreadFactory`.