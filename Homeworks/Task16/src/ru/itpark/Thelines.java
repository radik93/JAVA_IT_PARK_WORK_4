package ru.itpark;

public class Thelines implements setTexts {

    public String text;

    private int count;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void run() {

        char chars[] = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int aCode = (int) chars[i];
            if (aCode >= 65 && aCode <= 90 || aCode >= 97 && aCode <= 122) {
                count++;
            }
        }
        System.out.println("Количество букв: " + count);
    }
}
