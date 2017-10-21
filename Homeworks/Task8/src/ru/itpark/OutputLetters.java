package ru.itpark;

// вывод букв
public class OutputLetters implements Observer {
    int count;

    @Override
    public void handleEvent(char c) {
        int aCode;
        // char array[] = Text.toCharArray();
        // for (int i=0;i<array.length;i++)
        //  {
        aCode = (int) c;
        if (aCode >= 65 && aCode <= 90 || aCode >= 97 && aCode <= 122) {
            count++;
            System.out.println("Найдено букв: " + count);
        }
        //   }
        // System.out.println("Количество букв в строке: "+count);
    }
}
