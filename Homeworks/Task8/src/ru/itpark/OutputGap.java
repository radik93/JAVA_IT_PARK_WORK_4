package ru.itpark;
// вывод пробелов
public class OutputGap implements Observer{

    @Override
    public void handleEvent(String Text) {
        int count=0;
        int aCode;
        char array[] = Text.toCharArray();
        for (int i=0;i<array.length;i++)
        {
            aCode = (int)array[i];
            if (aCode == 32)
            {
                count++;
            }
        }
        System.out.println("Количество пробелов в строке: "+count);
    }
}
