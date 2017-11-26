package ru.itpark;

public class Thenumber implements setTexts {

    private String text;

    private int count;

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        char chars[] = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int aCode = (int) chars[i];
            if (aCode >= 48 && aCode <= 57) {
                count++;
            }
        }
        System.out.println("Количество цифр:" + count);
    }
}
