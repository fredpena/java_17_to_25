

/**
 * There is no direct API for Generational ZGC.
 * <p>
 * The feature is enabled/configured via JVM options, for example:
 * <p>
 * javac GenerationalZgcExample.java
 * java -XX:+UseZGC GenerationalZgcExample
 * <p>
 * This class just allocates some memory so you have something to profile.
 */

void main() throws InterruptedException {
    final int TOTAL_ALLOCATIONS = 10_000_000; // ~10 million allocations
    final int BATCH_SIZE = 200_000;          // Create garbage every ~200MB

    var list = new ArrayList<byte[]>(BATCH_SIZE);
    IO.println("Starting benchmark: " + TOTAL_ALLOCATIONS + " allocations in batches of " + BATCH_SIZE + ".");
    IO.println("----------------------------------------------------------");

    for (int i = 0; i < TOTAL_ALLOCATIONS; i++) {
        list.add(new byte[1024]); // Allocate 1 KB

        if (list.size() == BATCH_SIZE) {
            // Every ~200MB, clear half the list to create garbage
            // and print a timestamp to observe potential pauses.
            IO.println(Instant.now() + " - Allocated " + list.size() / 1024 + " MB. Creating garbage...");
            list.subList(0, list.size() / 2).clear();
            Thread.sleep(100); // Brief pause to allow GC to work
        }
    }

    IO.println("----------------------------------------------------------");
    IO.println("Benchmark finished.");
}
