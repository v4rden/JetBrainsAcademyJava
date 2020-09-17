class Circle {

    double radius;

    double getLength() {
        return Math.PI * (radius + radius);
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
}