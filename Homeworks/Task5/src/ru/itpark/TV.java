package ru.itpark;

import java.time.LocalTime;

public class TV implements Commutation {

    private static TV onlyTV;
    private Сhannel channel[];
    private String nameСhannel;

    private TV() {
        // this.channel = channel;
        //this.nameСhannel = nameСhannel;
    }

    static {
        // onlyTV = new TV(nameСhannel,channel);
        onlyTV = new TV();
    }

    //public TV(Сhannel channel[]) {
    //    this.channel = channel;
    //}

    public static TV onlyTV(String nameСhannel, Сhannel channel[]) {
        onlyTV.channel = channel;
        onlyTV.nameСhannel = nameСhannel;

        return onlyTV;
    }

    @Override
    public int switchСhannel(String nameСhannel) {
        for (int i = 0; i < channel.length; i++) {
            if (channel[i].getName().equalsIgnoreCase(nameСhannel)) {
                System.out.println(channel[i].selectTransfer(channel[i].getTransfer()));
                return 0;
            }
        }
        System.out.println("Канал не найден!");
        return -1;
    }

}
