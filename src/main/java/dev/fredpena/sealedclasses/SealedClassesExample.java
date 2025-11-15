

sealed interface Shape permits Circle, Rectangle, Square {
}

static final class Circle implements Shape {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }
}

static final class Rectangle implements Shape {
    final double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

static final class Square implements Shape {
    final double side;

    Square(double side) {
        this.side = side;
    }
}


static double area(Shape shape) {
    if (shape instanceof Circle c) {
        return Math.PI * c.radius * c.radius;
    } else if (shape instanceof Rectangle r) {
        return r.width * r.height;
    } else if (shape instanceof Square s) {
        return s.side * s.side;
    }
    throw new IllegalStateException("Unknown shape: " + shape);
}

void main() {
    Shape s1 = new Circle(2.0);
    Shape s2 = new Rectangle(2.0, 5.0);
    Shape s3 = new Square(3.0);

    IO.println(area(s1));
    IO.println(area(s2));
    IO.println(area(s3));
}
