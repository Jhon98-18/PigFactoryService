package com.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 3, 6};
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int temp = array[i];
            if(array[j] < array[j - 1]){
                for (j = i; temp < array[j - 1]; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = temp;
            }
        }
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
