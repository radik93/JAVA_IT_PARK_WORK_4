package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int a[] = new int[100];
        Scanner scaner = new Scanner(System.in);
        int oper,count=0,number;
        System.out.println("Меню:");
        System.out.println("1.Показать массив");
        System.out.println("2.Добавить в начало");
        System.out.println("3.Добавить в конец");
        System.out.println("4.Удалить по позиции");
        System.out.println("5.Выход");
        while (true){
            System.out.println("Выберите пункт меню:");
            oper = scaner.nextInt();
        switch (oper) {
            case 1:
                System.out.println("Элементы массива:");
                for (int i = 0; i < count; i++) {
                    System.out.print(a[i]);
                }
                break;
            case 2:
                if(!(count == 100)) {
                    for (int i = count; i > 0; i--) {
                        a[i] = a[i - 1];
                    }
                    System.out.print("Введите число:");
                    a[0] = scaner.nextInt();
                    count++;
                }
                else
                    System.out.println("Превышено максимальное допустимое количество значений!");
                break;
            case 3:
                if(!(count == 100)) {
                    System.out.print("Введите число:");
                    a[count] = scaner.nextInt();
                    count++;
                }
                else
                    System.out.println("Превышено максимальное допустимое количество значений!");
                break;
            case 4:
                System.out.print("Введите номер удаляемого элемента от 0 до "+(count==0 ? 0 : count-1));
                number = scaner.nextInt();
                for(int i = number;i<count;i++)
                {
                   a[i]=a[i+1];
                }
                count--;
                if (count <0)
                    count=0;
                break;
            case 5:
                System.exit(0);
                break;
                default:
                    System.out.print("Команда не определена");
                    break;
        }
        }
    }
}
