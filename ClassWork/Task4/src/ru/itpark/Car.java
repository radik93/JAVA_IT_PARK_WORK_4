package ru.itpark;

public class Car {
    private String number;
    private String color;
    private int power;

    public void setNumber(String number)
    {
        this.number = number;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public void setPower(int power)
    {
        this.power = power;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public int getPower() {
        return power;
    }
}
