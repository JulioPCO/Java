package Generics;

import java.util.Iterator;

public class GenericListIterable<T> implements Iterable<T>{ //Iterable allow to iterate without ever acessing the inside of the class, 
    private T[] items = (T[]) new Object[10];               //so if we change the class it doesn't affect the main program
    private int count;

    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T>{
        private GenericListIterable<T> list;
        private int index;

        public ListIterator(GenericListIterable<T> list){
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return (index < list.count);
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return list.items[index++];
        }
    }
}
