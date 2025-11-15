

// ScopedValue is incubator/preview in earlier JDKs, final in newer.

private static final ScopedValue<String> CURRENT_USER = ScopedValue.newInstance();

void main() {
    ScopedValue.where(CURRENT_USER, "alice")
            .run(() -> {
                IO.println("In scope: " + CURRENT_USER.get());
                child();
            });
}

private static void child() {
    IO.println("Child sees user: " + CURRENT_USER.get());
}
