


static String classify(Object o) {
    return switch (o) {
        case int i -> "int: " + i;
        case long l -> "long: " + l;
        case double d when d == Math.floor(d) -> "integral double: %s".formatted(d);
        case double d -> "non-integral double: " + d;
        default -> "other: " + o;
    };
}

void main() {
    IO.println(classify(42));
    IO.println(classify(42L));
    IO.println(classify(3.14));
    IO.println(classify(10.0));
    IO.println(classify("hello"));
}


