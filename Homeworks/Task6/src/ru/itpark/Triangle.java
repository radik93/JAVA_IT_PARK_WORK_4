package ru.itpark;

public class Triangle extends Area {
    // Стороны треугольника
    private int sideA;
    private int sideB;
    private int sideC;

    // площадь
    private double S;

    //периметр
    private double P;

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public void calculateArea() {
        P = (sideA + sideB + sideC) / 2;
        S = Math.sqrt(P * (P - sideA) * (P - sideB) * (P - sideC));
        System.out.println("Площадь треугольника равна: "+ S);
    }
}
