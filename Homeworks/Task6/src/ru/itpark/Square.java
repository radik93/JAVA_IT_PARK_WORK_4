package ru.itpark;

public class Square extends Area {
    //стороны квадрата
    private int sideA;
    private int sideB;

    //площадь
    private double S;

    public Square(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public void calculateArea() {
        S = sideA * sideB;
        System.out.println("Площадь квадрата равна: " + S);
    }
}
