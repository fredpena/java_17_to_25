


void main() throws InterruptedException {
    try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
        for (int i = 0; i < 10; i++) {
            final int id = i;
            executor.submit(() -> {
                IO.println("Running task " + id + " on " + Thread.currentThread());
                Thread.sleep(200);
                return null;
            });
        }
    }
    IO.println("All tasks finished.");
}
