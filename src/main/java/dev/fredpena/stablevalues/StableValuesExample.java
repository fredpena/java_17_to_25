
/**
 * Stable Values (Preview Feature, JDK 25+).
 * <p>
 * StableValue provides a mechanism for deferred, at-most-once initialization
 * of immutable data. It's a modern, safe, and efficient replacement for
 * patterns like double-checked locking.
 * <p>
 * This example demonstrates how to lazily initialize a "heavy" component,
 * improving application startup time. The component is only created when it's
 * first needed.
 * <p>
 * To compile and run (from the project root directory, using JDK 25+):
 * {@code javac --enable-preview --source 25 -d target/classes src/main/java/dev/fredpena/stablevalues/StableValuesExample.java src/main/java/dev/fredpena/utils/IO.java}
 * <p>
 * To run the example:
 * {@code java --enable-preview -cp target/classes dev.fredpena.stablevalues.StableValuesExample}
 */

/**
 * A simulated heavy component that is slow to initialize.
 */
static class HeavyComponent {
    HeavyComponent(String owner) {
        IO.println(">>> Initializing HeavyComponent for " + owner + "... (This is slow!)");
        try {
            // Simulate reading config, warming up cache, etc.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        IO.println(">>> HeavyComponent for " + owner + " is READY.");
    }

    void doWork() {
        IO.println("   ...HeavyComponent is doing work.");
    }
}

// Pattern 1: Using StableValue.of() and orElseSet()
private final StableValue<HeavyComponent> component = StableValue.of();

private HeavyComponent getComponent() {
    IO.println("Attempting to get component via orElseSet()...");
    // The lambda is only executed ONCE, the very first time this is called.
    return component.orElseSet(() -> new HeavyComponent("orElseSet"));
}

//  Pattern 2: A cleaner approach using StableValue.supplier()
private final Supplier<HeavyComponent> componentSupplier =
        StableValue.supplier(() -> new HeavyComponent("supplier"));

void main() {
    IO.println("Example instance created. Note that no components have been initialized yet.");
    IO.println("======================================================================");

    IO.println("\n--- Demo: orElseSet() Pattern ---");
    IO.println("About to call getComponent() for the first time.");
    getComponent().doWork();
    IO.println("\nAbout to call getComponent() for the second time (should be instant).");
    getComponent().doWork(); // Initialization is NOT repeated.

    IO.println("\n======================================================================");

    IO.println("\n--- Demo: supplier() Pattern ---");
    IO.println("About to call componentSupplier.get() for the first time.");
    componentSupplier.get().doWork();
    IO.println("\nAbout to call componentSupplier.get() for the second time (should be instant).");
    componentSupplier.get().doWork(); // Initialization is NOT repeated.
}
