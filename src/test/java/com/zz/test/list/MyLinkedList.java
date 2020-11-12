package com.zz.test.list;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    transient int size = 0;
    transient MyLinkedList.Node<E> first;
    transient MyLinkedList.Node<E> last;
    protected transient int modCount = 0;

    public static void main(String[] args) {
        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();
        integerMyLinkedList.addFirstz(3);
        integerMyLinkedList.addFirstz(2);
        integerMyLinkedList.addFirstz(1);

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirstz(6);
        myLinkedList.addFirstz(5);
        myLinkedList.addFirstz(4);
        integerMyLinkedList.splice(integerMyLinkedList.myListIterator(), myLinkedList);

    }

    public void splice(Iterator<E> itr, MyLinkedList<? extends E> myLinkedList) {
        Iterator<E> iterator = this.myListIterator();
        while (iterator.hasNext()) {
            E next = iterator.next();
            System.out.println(next + "=====");
        }
        /*int count = 0;
        Node<E> next = first;
        Node<E> current = first;
        while (count++ < size) {
            current = next;
            next = next.next;
        }*/


    }


    public MyLinkedList() {
    }

    public void addFirstz(E e) {
        linkFirst(e);
    }

    private void linkFirst(E e) {
        final MyLinkedList.Node<E> f = first;
        final MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }


    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public Iterator myListIterator() {
        return new MyListIterator();
    }


    private class MyListIterator implements ListIterator<E> {
        private MyLinkedList.Node<E> lastReturned;
        private MyLinkedList.Node<E> next;
        private int nextIndex;

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            return null;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
        }

        public void set(E e) {
        }

        public void add(E e) {
        }


    }
}
