package ru.itpark;

import java.time.LocalTime;

public class TV {
    private Сhannel channel[];
    private String nameСhannel;

    public TV(Сhannel channel[]) {
        this.channel = channel;
    }

    public int switchСhannel(String nameСhannel) {
        for (int i = 0; i < channel.length; i++) {
            if (channel[i].getName().equalsIgnoreCase(nameСhannel)) {
                selectTransfer(LocalTime.now(), channel[i].getTransfer());
                return 0;
            }
        }
        System.out.println("Канал не найден!");
        return -1;
    }

    private int selectTransfer(LocalTime currentTime, Transfer transfer[]) {
        for (int i = 0; i < transfer.length; i++) {
            if (currentTime.isAfter(transfer[i].getBeginTime()) &&
                    currentTime.isBefore(transfer[i].getEndTime())) {
                System.out.println(transfer[i].getName());
                return 0;
            }
        }
        System.out.println("Технический перерыв");
        return -1;
    }
}
