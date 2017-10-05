package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	   //Car car[] = {audi}
        Car audi = new Car();
        Car lada = new Car();
        Car BMV = new Car();
        Car car[] = {audi, lada, BMV};
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<car.length;i++)
        {
            car[i].setNumber(scanner.next());
            car[i].setColor(scanner.next());
            car[i].setPower(scanner.nextInt());
        }
        for(int i=car.length-1; i>0; i--)
        {
            for(int j=0; j<i; j++)
            {
                if(car[i].getPower()> car[i].getPower())
                {
                    Car temp = car[j];
                    car[j] = car[j+1];
                    car[j] = temp;
                }
            }
        }
        for (int i=0;i<car.length;i++)
        {
            System.out.println(car[i].getNumber());
            System.out.println(car[i].getColor());
            System.out.println(car[i].getPower());
        }
    }
}
