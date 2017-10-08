package ru.itpark;

public class Main {

    public static void main(String[] args) {

        Triangle triangle = new Triangle(15, 20, 30);
        Square square = new Square(10, 20);
        Circle circle = new Circle(10);

        Area areas[] = {triangle, square, circle};

        for (Area area : areas) {
            area.calculateArea();
        }
    }
}
