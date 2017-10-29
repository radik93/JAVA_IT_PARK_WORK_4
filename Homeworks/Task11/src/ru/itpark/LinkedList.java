package ru.itpark;

import java.awt.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;

    public Node<T> getTail() {
        return tail;
    }

    // указатель на конец списка
    private Node<T> tail;

    private int count;

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {

        private Node<T> currentNode = head;

        @Override
        public Object next() {
            T element = currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }


    private static class Node<E> {
        // значение, которое хранит узел
        E value;
        // указатель на следующий узел
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    public T get(int index) {
        if (index < 0 && index >= count) {
            throw new IllegalArgumentException();
        }
        // начинаем с первого элемнта
        Node<T> currentNode = head;
        // пока i меньше, чем index идем дальше
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        // значение currentNode
        return currentNode.value;
    }

}
