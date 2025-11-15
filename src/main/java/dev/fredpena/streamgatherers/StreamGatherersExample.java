

// Requires: java.util.stream.Gatherers (JDK 22+ preview/final)

void main() {
    IO.println("--------fold--------");
    List<String> stringStream = Arrays.asList("Paragraf 1", "Paragraf 2", "Paragraf 3", "Paragraf 4", "Paragraf 5", "Paragraf 6");


    var text2 = stringStream
            .stream()
            .gather(Gatherers.fold(() -> "", ((a, b) -> {
                if (a.isEmpty()) return b;
                return a + ";" + b;
            })))
            .findFirst()
            .orElse(null);

    IO.println("Gatherers text : " + text2);

    IO.println("--------reduce--------");
    String result = stringStream.stream()
            .reduce("", (a, b) -> a.isEmpty() ? b : a + ";" + b);

    IO.println("reduce : " + result);

    IO.println("--------windowFixed--------");
    Stream<Integer> windowFixedStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    var windows = windowFixedStream.gather(Gatherers.windowFixed(3));

    windows.forEach(IO::println);


    IO.println("-------windowSliding---------");
    List<Integer> windowSlidingStream = Arrays.asList(10, 8, 6, 3, 2, 40, 9);

    windowSlidingStream.
            stream().
            gather(Gatherers.windowSliding(2))
            .forEach(System.out::println);

    IO.println("----------------");

    windowSlidingStream.
            stream().
            gather(Gatherers.windowSliding(3))
            .forEach(System.out::println);


    IO.println("--------scan--------");
    List<Integer> scanStream = Arrays.asList(10, 8, 6, 3, 2);

    scanStream.stream()
            .gather(Gatherers.scan(() -> 100,
                    (current, next) -> current + next))
            .forEach(System.out::println);


    IO.println("----------------");

    int sum = scanStream.stream()
            .gather(Gatherers.scan(() -> 100,
                    (current, next) -> current + next))
            .findFirst().orElse(0);

    IO.println("sum scan : " + sum);
}
