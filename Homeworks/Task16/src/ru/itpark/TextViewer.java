package ru.itpark;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextViewer {

    private setTexts runnables[] = new setTexts[3];


    protected String text;

    private int count = 0;


    public void setText(String text) {
        this.text = text;
    }

    public TextViewer getTextViewer() {
        return this;
    }

    public void textProcess() {

            new Thread(() -> {
                for (int i = 0; i < count; i++) {
                    runnables[i].setText(text);
                    runnables[i].run();
                }
            }).start();
        }


    public void addTask(setTexts task) {
         runnables[count++] = task;
    }
}
