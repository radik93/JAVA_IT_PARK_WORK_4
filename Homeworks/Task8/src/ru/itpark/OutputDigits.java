package ru.itpark;
// вывод цифр
public class OutputDigits implements Observer{

    @Override
    public void handleEvent(String Text) {
        int count=0;
        int aCode;
        char array[] = Text.toCharArray();
        for (int i=0;i<array.length;i++)
        {
            aCode = (int)array[i];
            if (aCode >= 48 && aCode <= 57)
            {
                count++;
            }
        }
        System.out.println("Количество цифр в строке: "+count);
    }
}
