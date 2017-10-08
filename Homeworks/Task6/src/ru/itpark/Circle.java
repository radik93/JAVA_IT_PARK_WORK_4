package ru.itpark;

public class Circle extends Area {

    //стороны квадрата
    private int radius;

    //площадь
    private double S;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void calculateArea() {
        S = 3.14 * radius * radius;
        System.out.println("Площадь круга равна: " + S);
    }
}
