package ru.itpark;

import java.time.LocalTime;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Transfer transfers1 = new Transfer("Новости", LocalTime.parse("01:00"),
                LocalTime.parse("02:00"));
        Transfer transfers2 = new Transfer("Том и джерри", LocalTime.parse("02:00"),
                LocalTime.parse("03:00"));
        Transfer transfers3 = new Transfer("Кухня", LocalTime.parse("03:00"),
                LocalTime.parse("04:00"));

        Transfer transfers4 = new Transfer("Камеди клаб", LocalTime.parse("23:00"),
                LocalTime.parse("23:59"));
        Transfer transfers5 = new Transfer("Наша Раша", LocalTime.parse("00:00"),
                LocalTime.parse("03:00"));
        Transfer transfers6 = new Transfer("Школа ремонта", LocalTime.parse("03:00"),
                LocalTime.parse("04:00"));

        Сhannel cannel1 = new Сhannel("СТС", new Transfer[]{transfers1, transfers2, transfers3});
        Сhannel cannel2 = new Сhannel("ТНТ", new Transfer[]{transfers4, transfers5, transfers6});

        // TV tv = new TV(new Сhannel[]{cannel1, cannel2});

        Console console = new Console(new Сhannel[]{cannel1, cannel2});


        while (true) {
            System.out.println("Введите наименование канала");
            console.CommutatinChannel();
        }
    }
}
