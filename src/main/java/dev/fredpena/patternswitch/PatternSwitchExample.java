
String describe(Object obj) {
    return switch (obj) {
        case null -> "null!";
        case Integer i -> "int " + i;
        case Long l -> "long " + l;
        case String s when s.length() > 5 -> "long string " + s;
        case String s -> "short string " + s;
        default -> "something else: " + obj.getClass().getSimpleName();
    };
}

// Instance main method en la unnamed class
void main() {
    IO.println(describe(null));
    IO.println(describe(42));
    IO.println(describe(42L));
    IO.println(describe("hi"));
    IO.println(describe("hello world"));
}
