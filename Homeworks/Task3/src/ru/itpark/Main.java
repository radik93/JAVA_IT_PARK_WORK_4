package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        showMenu(); //вызываем процедуру для вывода меню
        selectProcess();// вызываем процедуру выбора пункта меню

    }

    public static void showMenu ()
    {
        System.out.println("Меню:");
        System.out.println("1.Показать массив");
        System.out.println("2.Добавить в начало");
        System.out.println("3.Добавить в конец");
        System.out.println("4.Удалить по позиции");
        System.out.println("5.Cортировка выбором");
        System.out.println("6.Выход");
    }
    public static void selectProcess()
    {
        int a[] = new int[100];
        int count=0;
        int oper;
        Scanner scaner = new Scanner(System.in);
        while (true){
        System.out.println("Выберите пункт меню:");
        oper = scaner.nextInt();
        switch (oper)
        {
            case 1:
                printArray(a, count);// вызываем процедуру для вывода массива
                break;
            case 2:
                if (fullArray(count))//выполняем если массив не переполнен
                {
                    System.out.print("Введите число:");
                    a = addFirstElement(count, a, scaner.nextInt());// вызываем функцию для добавления элемента в начало массива
                    count++;
                }
                break;
            case 3:
                if (fullArray(count)) //выполняем если массив не переполнен
                {
                    System.out.print("Введите число:");
                    a = addEndElement(count, a, scaner.nextInt());// вызываем функцию для добавления элемента в конец массива
                    count++;
                }
                break;
            case 4:
                System.out.print("Введите номер удаляемого элемента от 0 до " + (count == 0 ? 0 : count - 1));
                a = DelElement(count, a, scaner.nextInt());//вызываем функцию для удаления элемента массива
                count--;
                if (count < 0)
                    count = 0;
                break;
            case 5:
                a = insertsSorting(count, a, 0);//вызываем функцию сортировки выбором
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.print("Команда не определена");
                break;
        }
        }
    }
    public static void printArray(int a[], int count)
    {
        System.out.println("Элементы массива:");
        for (int i = 0; i < count; i++) {
            System.out.print(a[i]);
        }
    }
    public static boolean fullArray (int i)
    {
        if (i==100)
        {
            System.out.println("Превышено максимальное допустимое количество значений!");
            return false;
        }
        else
            return true;
    }
    public static int[] addFirstElement(int count, int a[], int newElement)
    {
        for (int i = count; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = newElement;
        return a;
    }
    public static int[] addEndElement(int count, int a[], int newElement)
    {
        a[count] = newElement;
        return a;
    }
    public static int[] DelElement(int count, int a[], int number)
    {
        for (int i = number; i < count; i++) {
            a[i] = a[i + 1];
        }
        return a;
    }
    public static int[] insertsSorting(int count, int a[], int number)
    {
        int min = number;
        int temp;
        if (number!=count)
        {
            for (int i = number; i < count-1; i++)
            {
                if (a[i + 1] < a[i])
                    min = i+1;
            }
            temp = a[number];
            a[number] = a[min];
            a[min] = temp;
            number++;
            insertsSorting(count, a, number);
        }
        return a;
    }
}
