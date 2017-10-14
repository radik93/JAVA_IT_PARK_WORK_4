package ru.itpark;

import java.util.Scanner;

public class Console {
    private Scanner scanner;

    private String nameСhannel;
    private Сhannel channel[];

    private Commutation commutation;

    public Console(Сhannel channel[]) {
        this.channel = channel;
        scanner = new Scanner(System.in);
        commutation = TV.onlyTV(nameСhannel, channel);
    }

    public void CommutatinChannel() {
        commutation.switchСhannel(scanner.next());
    }
}
