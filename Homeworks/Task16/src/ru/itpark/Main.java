package ru.itpark;

public class Main {

    public static void main(String[] args) {
	//Thenumber thenumber = new Thenumber("Hi 1");

        TextViewer textViewer = new TextViewer();
        textViewer.setText("Text 1");

        Runnable runnable1 = new Thenumber("Text 1");
        Runnable runnable2 = new Thelines("Text 1");
        textViewer.addTask(runnable1);
        textViewer.addTask(runnable2);
        textViewer.textProcess();
    }
}
