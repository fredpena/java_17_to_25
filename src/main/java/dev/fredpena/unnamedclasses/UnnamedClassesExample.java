

/**
 * Preview feature: implicit / unnamed classes with an `instance main` method.
 * <p>
 * The real preview code would look like:
 * <p>
 * void main() {
 * System.out.println("Hello from an unnamed class!");
 * }
 * <p>
 * But here we keep it valid for standard compilers by wrapping in a class.
 */
void main() {
    IO.println("Hello from an unnamed class!");
}

