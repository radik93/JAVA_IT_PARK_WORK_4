package ru.itpark;

public class Сhannel {
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
}
