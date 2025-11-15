

public record Point(int x, int y) {
}

public static String describe(Object o) {
    return switch (o) {
        case Point(int x, int y) when x == y -> "diagonal point (" + x + "," + y + ")";
        case Point(int x, int y) -> "point (" + x + "," + y + ")";
        default -> "not a point";
    };
}

void main() {
    IO.println(describe(new Point(10, 10)));
    IO.println(describe(new Point(10, 20)));
    IO.println(describe("hello"));
}
