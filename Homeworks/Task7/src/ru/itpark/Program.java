package ru.itpark;

public class Program {
    public static boolean isLetter(char c) // буква
    {
        int aCode = c;
        if (aCode >= 65 && aCode <= 90 || aCode >= 97 && aCode <= 122) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDigit(char c)// цифр 48 - 57 - цифры
    {
        int aCode = c;
        if (aCode >= 48 && aCode <= 57) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isUpper(char c) // заглавная буква 65 - 90 - заглавные буквы английского алфавита
    {
        int aCode = c;
        if (aCode >= 65 && aCode <= 90) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLower(char c)   // униженная буква 97 - 122 - строчные буквы английского алфавита
    {
        int aCode = c;
        if (aCode >= 97 && aCode <= 122) {
            return true;
        } else {
            return false;
        }
    }

    public static int parse(char number[]) {
        double count = 0;
        int k = 0;
        for (int i = 0; i < number.length; i++) {
            if (!((int) number[i] >= 48 && (int) number[i] <= 57)) {
                return -1;
            } else {
                switch ((int) number[i]) {
                    case 48:
                        k = 0;
                        break;
                    case 49:
                        k = 1;
                        break;
                    case 50:
                        k = 2;
                        break;
                    case 51:
                        k = 3;
                        break;
                    case 52:
                        k = 4;
                        break;
                    case 53:
                        k = 5;
                        break;
                    case 54:
                        k = 6;
                        break;
                    case 55:
                        k = 7;
                        break;
                    case 56:
                        k = 8;
                        break;
                    case 57:
                        k = 9;
                        break;
                }
                count = count + k * Math.pow(10, (number.length - i - 1));
            }

        }
        return (int) count;
    }
}
