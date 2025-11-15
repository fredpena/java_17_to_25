void main() {
    SequencedMap<String, Integer> map = new LinkedHashMap<>();
    map.put("first", 1);
    map.put("second", 2);
    map.put("third", 3);

    IO.println("First entry : " + map.firstEntry());
    IO.println("Last entry  : " + map.lastEntry());

    map.putFirst("zero", 0);
    IO.println("After putFirst:");
    map.forEach((k, v) -> IO.println(k + " -> " + v));
}
