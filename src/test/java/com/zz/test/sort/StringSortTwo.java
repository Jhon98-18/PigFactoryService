package com.zz.test.sort;

import java.util.ArrayList;

public class StringSortTwo {
    public static void main(String[] args) {
        String[] strings = {"ab", "cde", "fgh", "ijk", "lm", "n", "o"};
        radixSort(strings, 3);
    }

    public static void radixSort(String[] arr, int maxLen) {
        final int BUCKET = 256;
        ArrayList<String>[] wordsByLength = new ArrayList[maxLen + 1];
        ArrayList<String>[] buckets = new ArrayList[BUCKET];


        for (int i = 0; i < wordsByLength.length; i++) {
            wordsByLength[i] = new ArrayList<>();
        }

        for (int i = 0; i < BUCKET; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (String s : arr) {
            wordsByLength[s.length()].add(s);
        }

        int idx = 0;
        for (ArrayList<String> wordList : wordsByLength) {
            for (String s : wordList) {
                arr[idx++] = s;
            }
        }

        int startingIndex = arr.length;
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            startingIndex -= wordsByLength[pos + 1].size();

            for (int i = startingIndex; i < arr.length; i++) {
                buckets[arr[i].charAt(pos)].add(arr[i]);
            }


            idx = startingIndex;
            for (ArrayList<String> thisBucket : buckets) {
                for (String s : thisBucket) {
                    arr[idx++] = s;
                }
                thisBucket.clear();
            }
        }


    }

}
