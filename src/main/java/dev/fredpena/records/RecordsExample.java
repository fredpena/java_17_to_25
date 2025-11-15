public record Point(int x, int y) {
}

void main() {
    Point p = new Point(10, 20);
    IO.println(p);
    IO.println("x = " + p.x() + ", y = " + p.y());
}
