package ru.itpark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextViewer {

 //   private List<Runnable> list = new ArrayList();


    private Runnable runnables[] = new Runnable[3];

    private String text;

    private int count = 0, i=0;

    public void setText(String text) {
        this.text = text;
    }

    public void textProcess() {

            new Thread(() -> {
                for (int i = 0; i < count; i++) {
                    runnables[i].run();
                }
            }).start();
        }


    public void addTask(Runnable task) {
         runnables[count++] = task;
    }
}
