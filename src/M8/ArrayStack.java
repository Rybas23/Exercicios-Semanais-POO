package src.M8;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private ArrayList arrayList;

    public ArrayStack(){
        arrayList = new ArrayList<E>();
    }

    @Override
    public void push(E e) {
        arrayList.add(0, e);
    }

    @Override
    public E peek() {
        if (!arrayList.isEmpty()) {
            return (E) arrayList.get(0);
        }
        return null;
    }

    @Override
    public E pop() {
        if (!arrayList.isEmpty()) {
            E e = (E) arrayList.get(0);
            arrayList.remove(0);
            return e;
        }
        return null;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return arrayList.size() > index;
        }

        @Override
        public E next() {
            return (E) arrayList.get(index++);
        }
    }
}
