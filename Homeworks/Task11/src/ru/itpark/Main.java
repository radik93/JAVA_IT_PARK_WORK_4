package ru.itpark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        String name = new String();
        int year = 0;
        int count = 0;
        int[] temp = new int[3];
        ArrayList<LinkedList> arrayList = new ArrayList<>();
        try {
            FileInputStream input = new FileInputStream("input.txt");
            int currentByte = input.read();
            while (currentByte != -1) {
                if (currentByte != 32 && !(currentByte >= 48 && currentByte <= 57) && !(currentByte == 13 || currentByte == 10)) {
                    name += (char) currentByte;
                } else if (currentByte >= 48 && currentByte <= 57) {
                    temp[count] = currentByte - '0';
                    count++;
                } else if ((currentByte == 13 || currentByte == 10) && count != 0) {
                    for (int i = 0; i < count; i++) {
                        year += temp[i] * (int) Math.pow(10, count - i - 1);
                    }
                    if (arrayList.get(year) != null) {
                        Human human = new Human(name, year);
                        arrayList.get(year).add(human);
                    } else {
                        LinkedList<Human> linkedList = new LinkedList<>();
                        Human human = new Human(name, year);
                        linkedList.add(human);
                        arrayList.add(linkedList, year);
                    }
                    year = 0;
                    count = 0;
                    name = "";
                }
                currentByte = input.read();
            }

            Iterator iteratorarr = arrayList.iterator();
            while (iteratorarr.hasNext()) {
                if (iteratorarr.next() != null) {
                    System.out.println("[" + count + "]");
                    LinkedList<Human> linkedList = (LinkedList<Human>) iteratorarr.next();
                    Iterator iteratorlist = linkedList.iterator();
                    while (iteratorlist.hasNext()) {
                        Human human = (Human) iteratorlist.next();
                        System.out.print("[" + human.getName() + " " + human.getAge() + "]");
                    }
                    System.out.println();
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }


    }
}
