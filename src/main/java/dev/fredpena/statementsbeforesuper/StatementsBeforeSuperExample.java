
/**
 * Preview feature: allows some statements before super(...) in constructors.
 * <p>
 * Real preview code would allow:
 * <p>
 * class Child extends Parent {
 * Child(int x) {
 * System.out.println("Initializing...");
 * log(x);
 * super(x);
 * }
 * }
 * <p>
 * For compatibility, we use a standard form here but document the idea.
 */
static class Parent {
    final int value;

    Parent(int value) {
        this.value = value;
    }
}

static class Child extends Parent {
    Child(int value) {
        super(value);
    }
}

void main() {
    Child c = new Child(10);
    IO.println("Child value = " + c.value);
}
