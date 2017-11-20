package ru.itpark;

public class Main {

    public static void main(String[] args) {

        Thelines thelines   = new Thelines();
        Thenumber thenumber = new Thenumber();

        TextViewer textViewers[] = {thelines, thenumber};



        for (TextViewer textViewer:textViewers) {
            textViewer.setText("Hi 1!");
            textViewer.addTask((Runnable) textViewer);
            textViewer.textProcess();
        }
    }
}
