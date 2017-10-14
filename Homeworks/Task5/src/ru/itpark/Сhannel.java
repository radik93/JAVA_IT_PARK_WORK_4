package ru.itpark;

import java.time.LocalTime;

public class Сhannel implements ChannelSearch {
    private String name;
    private Transfer transfer[];

    public Сhannel(String name, Transfer transfer[]) {
        this.name = name;
        this.transfer = transfer;
    }

    public String getName() {
        return name;
    }

    public Transfer[] getTransfer() {
        return transfer;
    }

    @Override
    public String selectTransfer(Transfer transfer[]) {
        LocalTime currentTime = LocalTime.now();
        for (int i = 0; i < transfer.length; i++) {
            if (currentTime.isAfter(transfer[i].getBeginTime()) &&
                    currentTime.isBefore(transfer[i].getEndTime())) {
                return transfer[i].getName();
            }
        }
        return "Технический перерыв";
    }
}
