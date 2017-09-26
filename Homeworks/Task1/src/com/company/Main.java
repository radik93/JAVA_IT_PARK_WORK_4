package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i,a=0,b=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Считать 2 числа");
        System.out.println("2.Сумма чисел вывод");
        System.out.println("3.Разность чисел вывод");
        System.out.println("5.Выход");
	while(true)
    {
        i = scanner.nextInt();
        if(i==1)
        {
            System.out.print("Введите 1 число: ");
            a = scanner.nextInt();
            System.out.print("Введите 2 число: ");
            b = scanner.nextInt();
        }
        else if(i==2)
        {
            System.out.print("Сумма чисел равна:");
            System.out.println(a + b);
        }
        else if(i==3)
        {
            System.out.print("Разность чисел равна:");
            System.out.println(a - b);
        }
        else if(i==4)
        {
            System.out.print("Произведение чисел равно:");
            System.out.println(a * b);
        }
        else if(i==5)
        {
            System.exit(0);
        }
    }
    }
}
