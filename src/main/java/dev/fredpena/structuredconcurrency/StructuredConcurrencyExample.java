

// Requires preview/incubator API: StructuredTaskScope (JDK 21+ preview)
// java --enable-preview --add-modules jdk.incubator.concurrent StructuredConcurrencyExample.java

void main() throws Exception {
    try (var scope = StructuredTaskScope.open()) {

        var userFuture = scope.fork(() -> fetchUser());
        var ordersFuture = scope.fork(() -> fetchOrders());

        scope.join(); // Wait for both. Throws ExecutionException if a subtask fails.

        var user = userFuture.get();
        var orders = ordersFuture.get();

        IO.println("User    : " + user);
        IO.println("Orders  : " + orders);
    }
}

static String fetchUser() throws InterruptedException {
    Thread.sleep(200);
    return "User#123";
}

static String fetchOrders() throws InterruptedException {
    Thread.sleep(300);
    return "[order-1, order-2]";
}
