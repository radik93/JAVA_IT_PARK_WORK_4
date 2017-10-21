package ru.itpark;

// вывод цифр
public class OutputDigits implements Observer {
    int count = 0;

    @Override
    public void handleEvent(char c) {
        int aCode;
        //char array[] = Text.toCharArray();
        // for (int i=0;i<array.length;i++)
        // {
        aCode = (int) c;
        if (aCode >= 48 && aCode <= 57) {
            count++;
            System.out.println("Найдено цифр: " + count);
        }
        // }
        //  System.out.println("Количество цифр в строке: "+count);
    }
}
