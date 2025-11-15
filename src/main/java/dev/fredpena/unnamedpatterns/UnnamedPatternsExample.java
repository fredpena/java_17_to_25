


public record Point(int x, int y) {
}

void main() {
    Object obj = new Point(10, 20);

    if (obj instanceof Point(int x, _)) { // '_' is an unnamed pattern component
        IO.println("x = " + x);
    }

    // Unnamed local variable (discard)
    int _ = computeHeavy();
    // We don't care about the value, just side-effects.
}

static int computeHeavy() {
    IO.println("Doing some work...");
    return 42;
}
