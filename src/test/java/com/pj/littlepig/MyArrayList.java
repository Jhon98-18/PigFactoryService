package com.pj.littlepig;

import org.assertj.core.internal.Iterators;

import java.util.*;

import static java.lang.reflect.Array.getLength;
import static java.util.Objects.hash;

public class MyArrayList<E> implements Iterable {
    public static void main(String[] args) {

        int i = ( 49% 10);


        System.out.println(i);

        System.out.println("hello");
//        MyArrayList myArrayList = new MyArrayList(5);
//        myArrayList.add(1);
//        myArrayList.add(2);
//        myArrayList.add(3);
//        myArrayList.add(4);
//        myArrayList.add(5);
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(6);
//        integers.add(7);
//        integers.add(8);
//        myArrayList.addAll(integers);
//        System.out.println(myArrayList + "first");
//        myArrayList.removeAll(integers);
//        System.out.println(myArrayList + "end");
//        Iterator iterator = myArrayList.listIterator();
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            System.out.println(next);
//
//        }
        //TODO：今天已经把removeAll做完了
    }


    private final static Object[] EMPTY = {};
    Object[] objects;
    int size;

    MyArrayList(int size) {
        if (size > 0) {
            objects = new Object[size];
        } else {
            objects = EMPTY;
        }
    }

    void removeAll(Iterable<? extends E> items) {
        List<Object> array = getArray(items);
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (!array.contains(objects[i])) {
                objects[count++] = objects[i];
            } else {
                for (int j = count; j < size; j++) {
                    objects[j] = null;
                }
            }
        }


    }

    boolean addAll(Iterable<? extends E> item) {
        int iteSize = getIteSize(item);
        int minSize = iteSize + size;
        if (objects.length < minSize) {
            grow(minSize);
        }
        //int length = getLength(item);
        Iterator<? extends E> iterator = item.iterator();
        List<Object> array = getArray(item);
        Object[] objects = array.toArray();
        int size = array.size();
        System.arraycopy(objects, 0, this.objects, this.size, size);
        this.size += size;
        return size != 0;
    }

    private List<Object> getArray(Iterable<? extends E> item) {
        ArrayList<Object> objects = new ArrayList<>();
        Iterator<? extends E> iterator = item.iterator();
        while (iterator.hasNext()) {
            objects.add(iterator.next());
        }
        return objects;
    }


    boolean add(E e) {
        int minSize = 1 + size;
        if (objects.length < minSize) {
            grow(minSize);
        }
        objects[size++] = e;
        return true;
    }

    private void grow(int minSize) {
        objects = Arrays.copyOf(this.objects, minSize);
    }



 /*   int EnsureSizeEnough(Object[] objects, int minSize) {
            int le = objects.length;
            if (le < (minSize - le)) {
                size = minSize - le;
            }
        }
    }*/

    int getIteSize(Iterable<? extends E> item) {
        Iterator<? extends E> iterator = item.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "objects=" + Arrays.toString(objects) +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new MyArrayListIterator();
    }

    public Iterator listIterator() {
        return new MyArrayListIterator();
    }


    class MyArrayListIterator implements Iterator {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();

            return objects[current++];
        }
    }
}
