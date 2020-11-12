package com.zz.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import javax.xml.ws.Response;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        Student student = new Student();
        student.age = 18;
        student.name = "张三";
        Map map= new HashMap();
//
        JSONObject jsonObject = new JSONObject();
        Person<Student> person = new Person();
        person.add();

/*
        String a = "ab";
        String b = "cd";
        String c = "de";
        String d = "fg";
        String[] strings = new String[]{d, a, b, c};
        //radixSort(strings, 2);

        countingRadixSort(strings, 2);
        for (String s : strings) {
            System.out.println(s);
        }*/
    }

    public static void countingRadixSort(String[] arr, int stringLen) {
        final int BUCKETs = 256;

        int n = arr.length;
        String[] buffer = new String[n];

        String[] in = arr;
        String[] out = buffer;

        for (int pos = stringLen - 1; pos >= 0; pos--) {

            //257
            int[] count = new int[BUCKETs + 1];

            for (int i = 0; i < n; i++)
                count[in[i].charAt(pos) + 1]++;


            for (int b = 1; b <= BUCKETs; b++)
                count[b] += count[b - 1];

            for (int i = 0; i < n; i++)
                out[count[in[i].charAt(pos)]++] = in[i];

            String[] tmp = in;
            in = out;
            out = tmp;

            if (stringLen % 2 == 1)
                for (int i = 0; i < arr.length; i++)
                    out[i] = in[i];
        }
    }


    //按照StringLength对相应的字符串长度进行排序
    public static void radixSort(String[] arr, int stringLen) {
        final int Buckets = 256;
        ArrayList<String>[] buckets = new ArrayList[Buckets];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<>();

        for (int pos = stringLen - 1; pos >= 0; pos--) {
            for (String s : arr)
                buckets[s.charAt(pos)].add(s);
            int idx = 0;
            for (ArrayList<String> thisBucket : buckets) {
                for (String s : thisBucket)
                    arr[idx++] = s;

                thisBucket.clear();
            }
        }
    }
}

class Person<T> {


    /* T t;

     Person(T t) {
         this.t = t;
     }
 */
    public T add() {
        T t = JSONObject.parseObject("", new TypeReference<T>() {
        });
        return t;
    }


}

class Student {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

