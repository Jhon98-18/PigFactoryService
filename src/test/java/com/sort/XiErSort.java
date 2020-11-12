package com.sort;

public class XiErSort {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 3, 6};
        int grap = array.length / 2;
        for (int i = grap; i > 0; i /= 2) {
            System.out.println("i========" + i);
            for (int j = 1; j < array.length; j++) {
                System.out.println("j======"+j);
                int temp = array[j];
                int k = j;
                for (k = j; k >= i && temp < array[k - i]; k -= i) {
                    System.out.println("k======="+array[k]);
                    array[k] = array[k - i];
                }
                array[k] = temp;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
