package com.zz.test.list.linkeedList;

public class MyLinkedList<T> {

    int size;

    public void add(T data) {
        linkedLast(data);
    }

    public void linkedLast(T data) {
        int count = size;

        Node<T> tNode = new Node<>(null, data, null);
    }


    private class Node<T> {
        Node<T> previous;
        T data;
        Node<T> next;

        public Node(Node<T> previous, T data, Node<T> next) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public Node() {
        }
    }




    /**/
/*
    private boolean insertHelper(AnyType x) {
        //记录循环的最大次数
        final int COUNT_LIMIT = 100;
        while (true){
            //记录上一个元素位置
            int lastPos = -1;
            int pos;
            //进行查找插入
            for (int count = 0; count < COUNT_LIMIT; count ++){
                for (int i = 0; i < numHashFunctions; i ++){
                    pos = myHash(x, i);
                    //查找成功，直接返回
                    if (array[pos] == null){
                        array[pos] = x;
                        currentSize ++;
                        return true;
                    }
                }
                //查找失败，进行替换操作，产生随机数位置，当产生的位置不能与原来的位置相同
                int i = 0;
                do {
                    pos = myHash(x, r.nextInt(numHashFunctions));
                } while (pos == lastPos && i ++ < 5);
                //进行替换操作
                AnyType temp = array[lastPos = pos];
                array[pos] = x;
                x = temp;
            }
            //超过次数，还是插入失败，则进行扩表或rehash操作
            if (++ rehashes > ALLOWED_REHASHES){
                expand();
                rehashes = 0;
            } else {
                rehash();
            }
        }
    }*/
}
