package ru.itpark;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextViewer {

    //private setTexts runnables[] = new setTexts[3];

    List<setTexts> runnables = new ArrayList<>();


    private String text;

    private int count = 0;


    public void setText(String text) {
        this.text = text;
    }

    public TextViewer getTextViewer() {
        return this;
    }

    public void textProcess() {


        Iterator<setTexts> iterator = runnables.iterator();

        while (iterator.hasNext()) {
            setTexts task = iterator.next();
            new Thread(() ->
            {
                task.setText(text);
                task.run();

            }
            ).start();
        }
    }

    public void addTask(setTexts task) {
        runnables.add(task);
        //[count++] = task;
    }
}
