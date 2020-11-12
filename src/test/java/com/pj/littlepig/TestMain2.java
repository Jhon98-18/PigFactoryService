package com.pj.littlepig;

import com.pj.littlepig.pojo.SysUser;

import java.util.*;

public class TestMain2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(0%1);
        /*LinkedList<Integer> integers = new LinkedList<>();
        //ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            integers.add(i);
        }
        *//*long start = System.currentTimeMillis();
        makeList(2);
        long end = System.currentTimeMillis();
        System.out.println(end - start);*//*
        //热土豆传递问题
        //hotPot2(integers, 3);
        //1 2 3 4 5
        //计算程序运行时间
        long sta = System.currentTimeMillis();
        removeFirstHalf(integers);
        long en = System.currentTimeMillis();
        System.out.println("当前程序运行花费了" + (en - sta));*/


    }

    public static List<Integer> makeList(int N) throws InterruptedException {
        ArrayList<Object> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lst.add(i);
            lst.trimToSize();
        }
        //Thread.sleep(10);
        return null;
    }


    public static void removeFirstHalf(List<?> list) throws InterruptedException {
        Iterator<?> iterator = list.iterator();
        int theSize = list.size() / 2;
        int count = 0;
        while (iterator.hasNext() && count++ <= theSize) {
            iterator.next();
            iterator.remove();
        }
        /*int theSize = list.size() / 2;
        for (int i = 0; i < theSize; i++) {
            list.remove(0);
        }*/
    }




   /* public static void betterJosephus(LinkedList<Integer> list, int m) {
        Iterator<Integer> itr = list.iterator();
        int count = 0;
        while (list.size() > 1) {
            if (!itr.hasNext()) {
                itr = list.iterator();
            }
            int temp = -1;
            while (itr.hasNext() && count++ <= m) {
                temp = itr.next();
            }
            if (count > m) {
                count = 0;
                 System.out.println(temp+"real");
                itr.remove();
            }
        }
        System.out.println("winner is " + list.getFirst());
    }*/

    static void hotPot(List integers, int times) {
        int count = 0;
        while (integers.size() > 1) {
            Iterator iterator = integers.iterator();

            if (iterator.hasNext()) {

            }


            for (int i = 0; i < times; i++) {
                count++;
            }
            System.out.println(count);
            while (count >= integers.size()) {
                count = count - integers.size();
            }
            integers.remove(count);
        }
        System.out.println(integers);
    }


    public static void josephus(LinkedList<Integer> list, int m) {
        int i = 0;
        while (list.size() > 1) {
            for (int j = 0; j < m; j++) {
                i++;
            }

            //1 2 3 4 5
            System.out.println(i);
            while (i >= list.size()) {
                i = i - list.size();
                System.out.println(i + "##");
            }
            System.out.println(list.get(i) + "remove");
            list.remove(i);
        }
        System.out.println("winner is " + list.get(0));
    }

}
