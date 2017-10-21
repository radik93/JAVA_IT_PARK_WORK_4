package ru.itpark;

// вывод пробелов
public class OutputGap implements Observer {
    int count = 0;

    @Override
    public void handleEvent(char c) {
        int aCode;
        // char array[] = Text.toCharArray();
        //  for (int i=0;i<array.length;i++)
        //     {
        aCode = (int) c;
        if (aCode == 32) {
            count++;
            System.out.println("Найдено пробелов: " + count);
        }
        // }
        // System.out.println("Количество пробелов в строке: "+count);
    }
}
