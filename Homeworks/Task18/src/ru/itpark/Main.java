package ru.itpark;

public class Main {

    public static void main(String[] args) {

        BinNode binNode = new BinNode(1);

        binNode.add(binNode.node, 2);
        binNode.add(binNode.node, 4);
        binNode.add(binNode.node, 8);
        binNode.add(binNode.node, 0);
        binNode.add(binNode.node, 9);
        binNode.add(binNode.node, 11);

        binNode.postfix();
        binNode.prefix();
        binNode.infix();
    }
}
