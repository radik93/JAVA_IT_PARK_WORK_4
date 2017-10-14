package ru.itpark;

import java.time.LocalTime;

public interface Commutation {
    public int switchСhannel(String nameСhannel);

    public int selectTransfer(LocalTime currentTime, Transfer transfer[]);
}
