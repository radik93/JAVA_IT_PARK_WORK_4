package ru.itpark;

public class Main {

    public static void main(String[] args) {

        if (Program.isLetter('g')) {
            System.out.println("Это буква");
        } else {
            System.out.println("Это не буква");
        }

        if (Program.isDigit('g')) {
            System.out.println("Это цифрв");
        } else {
            System.out.println("Это не цифра");
        }

        if (Program.isUpper('g')) {
            System.out.println("Это заглавная буква");
        } else {
            System.out.println("Это не заглавная буква");
        }

        if (Program.isLower('g')) {
            System.out.println("Это униженная буква");
        } else {
            System.out.println("Это не униженная буква");
        }

        char number[] = {'1', '4', '5', '6'};
        int x = Program.parse(number);
        if (x != -1) {
            System.out.println(x);
        } else {
            System.out.println("Введено недопустимое значение");
        }
    }
}
