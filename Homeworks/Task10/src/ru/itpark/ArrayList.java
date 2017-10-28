package ru.itpark;

public class ArrayList implements List {

    Object[] object = new Object[10];

    int count;

    @Override
    public void add(Object element) {
        object[count]=element;
        count++;
    }

    @Override
    public void addToBegin(Object element) {
        for(int i=count;i<0;i--)
        {
            object[i]=object[i-1];
        }
        object[0]=element;
        count++;

    }

    @Override
    public Object get(int index) {
        if(index<count && index>=0)
        {
            return object[index];
        }
        else {
            return null;
        }
    }

    @Override
    public void remove(Object element) {
        for(int i=0;i<count;i++)
        {
            if(object[i].equals(element))
            {
                for (int j = i;j<count;j++)
                {
                    object[j]=object[j++];
                }
                count--;
                break;
            }
        }

    }

    @Override
    public int indexOf(Object element) {
        for (int i=0;i<count;i++)
        {
            if(object[i].equals(element))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return new ArraydListIterator();
    }

    private class ArraydListIterator implements Iterator {

        int index;

        @Override
        public Object next() {
            return object[index++];
        }

        @Override
        public boolean hasNext() {
            return index!= count;
        }
    }
}