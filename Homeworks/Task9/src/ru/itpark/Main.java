package ru.itpark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        int age[] = new int[100];
        int count = 0;
        int[] temp = new int[3];
        int buf = 0;
        try {
            FileInputStream input = new FileInputStream("input.txt");
            int currentByte = input.read();
            while (currentByte != -1) {
                if (currentByte >= 48 && currentByte <= 57) {
                    temp[count] = currentByte - '0';
                    count++;
                }
                if ((currentByte == 13 || currentByte == 10) && count != 0) {
                    for (int i = 0; i < count; i++) {
                        buf = buf + temp[i] * (int) Math.pow(10, count - i - 1);
                    }
                    age[buf] = age[buf] + 1;
                    count = 0;
                    buf = 0;
                }
                currentByte = input.read();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        for (int i = 0; i < age.length; i++) {
            if (age[i] != 0) {
                System.out.println("Людей в возрасте " + i + " - " + age[i] + " шт.");
            }
        }
    }
}
