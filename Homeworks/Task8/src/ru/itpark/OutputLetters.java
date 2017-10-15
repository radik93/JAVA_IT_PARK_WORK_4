package ru.itpark;
// вывод букв
public class OutputLetters implements Observer{

    @Override
    public void handleEvent(String Text) {
        int count=0;
        int aCode;
        char array[] = Text.toCharArray();
        for (int i=0;i<array.length;i++)
        {
            aCode = (int)array[i];
            if (aCode >= 65 && aCode <= 90 || aCode >= 97 && aCode <= 122)
            {
                count++;
            }
        }
        System.out.println("Количество букв в строке: "+count);
    }
}
