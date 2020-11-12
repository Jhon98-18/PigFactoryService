/*
package com.pj.littlepig.link;

import com.fasterxml.jackson.databind.MappingIterator;
import com.pj.littlepig.MyArrayList;

import java.util.*;
import java.util.function.Consumer;

public class MyLinkedList<E> implements Iterable {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        //myLinkedList.printList();
        System.out.println(myLinkedList.getSize());
        //TODO：添加已经完成下一步是实现具体功能。。。
        //包含测试
        boolean contain = myLinkedList.contain(5);
        System.out.println(contain);
        myLinkedList.printList();

        ArrayList<Object> objects = new ArrayList<>();
        ListIterator<Object> objectListIterator = objects.listIterator();
    }

//todo:写不下了
    public void splice(Iterator<E> itr, MyLinkedList<? super E> myLinkedList) {

        Iterator< E> iterator = myLinkedList.iterator();

        while (itr.hasNext()) {
            E next = iterator.next();
            myLinkedList.add(next);
        }

        itr = iterator;

    }

    @Override
    public Iterator iterator() {
        return new MyListIterator();
    }

    public Iterator myListIterator() {
        return new MyListIterator();
    }


    private class MyListIterator implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
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
            return lastReturned.data;
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


    MyLinkedList() {

    }

    Node<E> first;
    int size;


    //编写一个单链表，使用头结点实现，但是无尾节点，并假设他只保留对该头节点的引用，编写一 个类。

    //返回链表的大小
    public int getSize() {
        return size;
    }

    //打印链表
    public void printList() {
        System.out.println(first);
    }

    //测试值x是否包含于链表
    public boolean contain(E e) {
        Node<E> next = first;
        Node<E> current = first;
        boolean result = false;
        int count = 0;
        while (count++ < size) {
            if (e.equals(next.data)) {
                current.next = (next.next != null) ? next.next : null;
            }
            current = next;
            next = next.next;
        }
        current.next = new Node<E>(e);
        return result;

    }

    //如果值x没有在链表中就把数据加到链表中
    public void containAndAdd(E e) {
        boolean contain = contain(e);
        if (!contain) {
            add(e);
        } else {
            remove(e);
        }
    }

    //删除
    public void remove(E e) {
    }


    //添加
    public void add(E e) {
        Node<E> eNode;
        if (first == null) {
            first = new Node<>(e, null);
            size++;
        } else {
            addToLast(e);
            size++;
        }

    }


    //添加文件尾部
    public void addToLast(E e) {
        int count = 0;
        Node<E> next = first;
        Node<E> current = first;
        while (next != null) {
            current = next;
            next = next.next;
            count++;
        }
        current.next = new Node<E>(e);
    }

    void eachList() {
        Node<E> next = first;
        while (next != null) {
            System.out.println(next);
            next = next.next;
        }
    }


}


*/
