//package com.pj.littlepig;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.mybatis.generator.api.MyBatisGenerator;
//import org.mybatis.generator.config.Configuration;
//import org.mybatis.generator.config.xml.ConfigurationParser;
//import org.mybatis.generator.internal.DefaultShellCallback;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.*;
//import java.util.regex.Pattern;
//
//public class GeneralMain {
//    public static void main(String[] args) throws Exception {
//        GeneralMain generatorSqlmap = new GeneralMain();
//        generatorSqlmap.generator();
//    }
//
//    public void generator() throws Exception {
//
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        //指向逆向工程配置文件
//        File configFile = new File("mybatisgeneral.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
//                callback, warnings);
//        myBatisGenerator.generate(null);
//
//    }
//}
//
//class Tetemain2 {
//    /*
//     * 有两个表一个l一个p现在要定义一个方法printL（l,p）要求打印l中下标为p的值
//     * */
//    public static void main(String[] args) throws IOException {
//        /*List l = new ArrayList();
//        List p = new ArrayList();
//        l.add("张三");//0
//        l.add("李四");
//        l.add("王五");
//        l.add("赵柳");
//        l.add("二麻子");
//        l.add("二狗");
//        l.add("四傻子");
//        p.add(1);
//        p.add(3);
//        p.add(5);
//        p.add(6);
//        printL(l, p);*/
//
//
//        SingleLink<Integer> list = new SingleLink<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.swap(2);
//        list.displayAllNodes();
//    }
//
//    public static void printL(List l, List p) {
//        Iterator iterator = p.iterator();
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            System.out.println(l.get((Integer) next));
//        }
//        /*for (Object num : p) {
//            System.out.println(l.get((Integer) num));
//        }*/
//
//    }
//}
///*
// * 下面实现一个单链表
// * */
//
//class Node<E> {
//    public Node<E> next;
//    E item;
//
//    public Node(E data) {
//        this.item = data;
//    }
//
//    public Node(E data, Node<E> next) {
//        this.item = data;
//        this.next = next;
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" +
//
//                "item=" + item +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Node<?> node = (Node<?>) o;
//        return Objects.equals(next, node.next) &&
//                Objects.equals(item, node.item);
//    }
//
//}
//
//class SingleLink<E> {
//    private static int size = 0;
//    private int position = 0;//节点位置
//    private Node<E> first;
//    private Node<E> last;
//
//    /**
//     * 在头结点添加一个数据
//     *
//     * @param data
//     */
//    public void addFirstNode(E data) {
//        Node<E> eNode = new Node<>(data);
//        eNode.next = first;
//        first = eNode;
//    }
//
//    /**
//     * 删除头结点,并且返回头结点
//     *
//     * @param
//     */
//    public Node deleteFirstNode() {
//        first = first.next;
//        return first;
//    }
//
//    /**
//     * // 在任意位置插入节点 在index的后面插入
//     */
//    public void add(int index, E data) {
//        //需要获取index的值
//        if (index == size) {
//            linkLast(data);
//        } else {
//
//            Node<E> newNode = new Node<>(data);
//            Node node = this.getBeforeIndex(index);
//            if (node != null) {
//                newNode.next = node.next;
//                node.next = newNode;
//            } else {
//                addFirstNode(data);
//            }
//
//        }
//
//    }
//
//    //根据指定index获取对应集合中存放数据
//    Node getBeforeIndex(int index) {
//        position = 0;
//        Node current = first;
//        Node previous = null;
//        while (current != last) {
//            if (index == position) {
//                position = 0;
//                return previous;
//            }
//            previous = current;
//            current = current.next;
//            position++;
//        }
//        return previous;
//    }
//
//    SingleLink() {
//    }
//
//
//    boolean add(E data) {
//        linkLast(data);
//        return true;
//    }
//
//    //添加
//    void linkLast(E data) {
//        final Node<E> newNode = new Node(data);
//        if (last == null)
//            first = newNode;
//        else
//            last.next = newNode;
//        last = newNode;
//        size++;
//    }
//    //展示集合所有元素
//
//    void displayAllNodes() {
//        System.out.println("展示所有信息");
//        Node current = first;
//        while (current != null) {
//            System.out.println(current.toString());
//            current = current.next;
//        }
//    }
////交换两个相邻数据
//
//    void swap(E n1) {
//        //target       2.pre   node   tar = node.next   node.next = 3   tar.next = 4  3.next = tar
//
//
//        //1,2,3,4,5
//
//        Integer index = getIndex(n1);
//        Node n1BeforeIndex = getBeforeIndex(index);
//        Node nodeN1 = n1BeforeIndex.next;
//        Node n1Next = n1BeforeIndex.next.next;
//        Node n2Next = n1BeforeIndex.next.next.next;
//
//        n1BeforeIndex.next = n1Next;
//        n1Next.next = nodeN1;
//        nodeN1.next = n2Next;
//    }
//
//    //getIndexByNode
//    Integer getIndex(E data) {
//        Node current = first;
//        position = 0;
//        while (!current.item.equals(data)) {
//            current = current.next;
//            position++;
//        }
//        return position;
//
//    }
//
//}