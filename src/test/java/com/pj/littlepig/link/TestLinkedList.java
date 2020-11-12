package com.pj.littlepig.link;

import java.util.Iterator;
import java.util.LinkedList;

public class TestLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    TestLinkedList() {
    }

    boolean add(E e) {
        Node<E> eNode = new Node<>(e);
        if (first == null) {
            first = eNode;
        } else {
            eNode.previous = last;
            last.next = eNode;
        }
        last = eNode;
        size++;
        return true;
    }


    public Iterator<E> iterator() {
        return new TestLinkedIterator();
    }

    public Iterator<E> reverseIterator() {
        return new TestReverseIterator();
    }

    private class TestLinkedIterator implements Iterator {
        int count = 0;
        Node<E> current = first;
        Node<E> next = first;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                current = next;
                next = next.next;
                count++;
            }
            return current;
        }
    }

    private class TestReverseIterator implements Iterator {
        int count = size;
        Node<E> current = last;
        Node<E> previous = last;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                current = previous;
                previous = current.previous;
                count--;
            }
            return current;
        }
    }
}


class TestMain {
    public static void main(String[] args) {
        System.out.println("   1321");
        int win = getWin(1, 5);
        System.out.println(win);
        /*TestLinkedList<Integer> list = new TestLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Node<Integer> next = (Node<Integer>) iterator.next();
            System.out.println(next.data);
        }
        System.out.println("===============");
        Iterator reverseIterator = list.reverseIterator();
        while (reverseIterator.hasNext()) {
            Node<Integer> next = (Node<Integer>) reverseIterator.next();
            System.out.println(next.data);
        }*/
    }

    public static int getWin(int time, int size) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {
            linkedList.add(i+1);
        }

        Iterator iterator = linkedList.iterator();
        int count = 0;
        while (linkedList.size() > 1) {
            if (!iterator.hasNext()) {
                iterator = linkedList.iterator();
            }
            Object next = null;
            while (iterator.hasNext()&& count++ <= time) {
                 next = iterator.next();

            }
            if (count > time) {
                iterator.remove();
                System.out.println(next);
                count = 0;
            }


        }
        return (int) linkedList.get(0);
    }

}
