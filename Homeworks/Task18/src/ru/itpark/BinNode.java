package ru.itpark;

public class BinNode {

    Node node;

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    public BinNode(int value)
    {
        node = new Node(value);
    }

    public void add(Node current, int value)
    {

        if(current.value > value)
        {
            if(current.left==null)
            {
                current.left = new Node(value);
            }
            else
            {
                add(current.left, value);
            }
        }
        else if(current.value < value)
        {
            if(current.right==null)
            {
                current.right = new Node(value);
            }
            else
            {
                add(current.right, value);
            }
        }

    }

    public void postfix() {
        System.out.println("Постфик : ");
        postfixСircumvention(this.node);
        System.out.println();

    }

    public void prefix() {
        System.out.println("Префикс : ");
        prefixСircumvention(this.node);
        System.out.println();
    }

    public void infix() {
        System.out.println("Инфикс : ");
        infixСircumvention(this.node);
        System.out.println();

    }

    public void postfixСircumvention(Node node)
    {
        if (node != null) {
            prefixСircumvention(node.left);
            prefixСircumvention(node.right);
            System.out.print(node.value + " ");
        }
    }
    public void prefixСircumvention(Node node)
    {
        if (node != null) {
            System.out.print(node.value + " ");
            prefixСircumvention(node.left);
            prefixСircumvention(node.right);
        }
    }

    public void infixСircumvention(Node node)
    {
        if (node != null) {

            infixСircumvention(node.left);
            System.out.print(node.value + " ");
            infixСircumvention(node.right);
        }
    }
}
