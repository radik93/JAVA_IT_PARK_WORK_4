package ru.itpark;

public class Main {

    public static void main(String[] args) {

        TextViewer textViewer = new TextViewer();

        textViewer.setText("Hi 1!");

        setTexts runnable1 = new Thelines();
        setTexts runnable2 = new Thenumber();



        textViewer.addTask(runnable1);
        textViewer.addTask(runnable2);
        textViewer.textProcess();

    }
}
