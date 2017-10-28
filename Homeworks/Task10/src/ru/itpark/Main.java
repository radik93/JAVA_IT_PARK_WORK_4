package ru.itpark;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.add("Fourth");
        linkedList.add("Fifth");
        linkedList.addToBegin("Zeroth");

//        for (int i = 0; i < linkedList.size(); i++) {
//            System.out.println(linkedList.get(i));
//        }

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");

        Iterator iteratorarr = arrayList.iterator();
        while (iteratorarr.hasNext()) {
            System.out.println(iteratorarr.next());
        }
    }

}

