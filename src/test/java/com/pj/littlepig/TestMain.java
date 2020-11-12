/*
package com.pj.littlepig;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        */
/*DoubleLink doubleLink = new DoubleLink();
        doubleLink.add(1);
        doubleLink.add(2);
        doubleLink.add(3);
        doubleLink.add(4);
        doubleLink.displayLink();
        doubleLink.swap(2);
        System.out.println("=============");
        doubleLink.displayLink();

        //完成DoubleLink的contain的例程  遍历集合中的每个元素和当前元素进行对比
        boolean contain = doubleLink.contain(5);
        System.out.println(contain);*//*

        //使用两个集合求出他们的交集
        */
/*List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        List<Integer> integers = new ArrayList<>();

        for (Integer integer : list) {
            if (list2.contains(integer))
                integers.add(integer);
        }
        System.out.println(integers);

        //并集
        list.addAll(list2);
        System.out.println(list);*//*

        */
/*for (Integer integer : list) {
            list2.add(integer);
        }
        System.out.println(list2);
*//*


        //热土豆问题
        List<Integer> lists = new ArrayList(5);
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        //int win = getColl(5, 2);
    }

    private static int getColl(int size, int time) {
        List<Integer> lists = new ArrayList(size);
        int currentSize = lists.size();
        int size1 = lists.size();
        int nextPeople;
        for (int i = 0; i < currentSize; i++) {

            int index = i + time;
            nextPeople = index + 1;
            if (nextPeople > size1) {
                int abs = Math.abs(currentSize - nextPeople);

                getColl(currentSize, time);
            }
            if (index < size) {
                lists.remove(index);
                currentSize = lists.size();
            } else {
                Math.abs(currentSize - index);
            }

          */
/*  1 2 3 4 5
            2 次 5
            3 - | 1 - 3 + 2 = 5 5 - 5 = 0 1 -
                    2 4 5 5 - 2 - 0 + 2 = 2 2 - 2 = 0 可以用这种方法 来定位需要删除的项

            1245
            int realIndex = getRealIndex(time, currentSize);


            lists.remove(i + time);
            lists.get(i + time)
            first = integers[0];
            clearPeopleINdex = i + time;
            clearPeople = integers[clearPeopleINdex];

            nextPeopleIndex = clearPeopleINdex + 1;
            //获取真正的index
            nextPeopleIndex = getRealIndex(nextPeopleIndex);

            getRealIndex(Integer index) {
                if (index > size) {
                    //1 2 3 4 5  4+3 = 6  5-7= 2
                    int abs = Math.abs(size - index);
                    return abs;
                } else {
                    return index;
                }

            }
            nextPeople = integers[nextPeopleIndex];
            //current.next  一next为null是完成  二就是增加size如何循环  一共用5个人  次数是二 第四个人怎么传给第一个人   4+2
            //不能用值来加要用索引
            if (current > current)*//*

        }
    }

    int each(int startIndex, int time, int size) {
        for (int i = startIndex; i < size; i++) {
            int nextSize;
            int index = i + time;
            if (index > size) {
                startIndex(nextStartIndex,time,nextSize);
            }
        }
    }

    static int getRealIndex(int index, int size) {
        if (index > size) {
            //1 2 3 4 5  4+3 = 6  5-7= 2
            int abs = Math.abs(size - index);
            return abs;
        } else {
            return index;
        }
    }
}

   */
/* int getColl(int size, int time) {
        Integer[] integers = new Integer[size];
        int first;
        for (int i = 0; i < size; i++) {
            first = integers[0];
            clearPeopleINdex = i + time;
            clearPeople = integers[clearPeopleINdex];

            nextPeopleIndex = clearPeopleINdex + 1;
            //获取真正的index
            nextPeopleIndex =  getRealIndex(nextPeopleIndex);

            getRealIndex(Integer index) {
                if (index > size) {
                    //1 2 3 4 5  4+3 = 6  5-7= 2
                    int abs = Math.abs(size - index);
                    return abs;
                } else {
                    return index;
                }

            }
            nextPeople = integers[nextPeopleIndex];
            //current.next  一next为null是完成  二就是增加size如何循环  一共用5个人  次数是二 第四个人怎么传给第一个人   4+2
            //不能用值来加要用索引
            if (current > current)
        }
    }*//*



//创建一个双链表结构的集合

class Node<E> {
    Node<E> previous;
    E data;
    Node<E> next;

    Node(Node<E> previous, E data, Node<E> next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }


    @Override
    public String toString() {
        return " data=" + data;
    }
}

//双向链表
class DoubleLink<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;

    DoubleLink() {
    }

    boolean add(E e) {
        linkedLast(e);
        return true;
    }

    private void linkedLast(E e) {
        Node<E> l = last;
        Node<E> eNode = new Node<>(l, e, null);
        last = eNode;
        if (l == null) {
            first = eNode;
        } else {
            l.next = eNode;
            size++;
        }
    }

    //1,2,3,4
    void swap(E e1) {
        Node<E> e1Node = node(e1);
        Node<E> e1NodePrevious = e1Node.previous;
        Node<E> e2Node = e1Node.next;
        Node<E> e2NodeNext = e2Node.next;

        e1NodePrevious.next = e2Node;
        e2Node.previous = e1NodePrevious;

        e1Node.previous = e2Node;
        e2Node.next = e1Node;
        e1Node.next = e2NodeNext;
    }

    Node<E> node(E e1) {
        Node<E> current = first;
        while (!current.data.equals(e1)) {
            current = current.next;
        }
        return current;
    }

    void displayLink() {
        int position = 0;
        Node<E> current = first;
        while (position <= size) {
            if (current != null) {
                System.out.println(current);
                current = current.next;
                position++;
            }
        }
    }

    boolean contain(E e) {

        Node<E> current = first;
        boolean result = false;
        while (current != null) {
            if (e.equals(current.data)) {
                result = true;
            }
            current = current.next;
        }
        return result;
    }

}*/
