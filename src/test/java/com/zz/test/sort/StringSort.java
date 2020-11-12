package com.zz.test.sort;


public class StringSort {
    public static void main(String[] args) {
        String[] strings = new String[]{"hi", "de", "bc", "fg","ab"};
        String[] sort = sort(strings, 2);
        for (String s : sort) {
            System.out.println(s);
        }
    }

    private static String[] sort(String[] strings, int length) {

        final int BUCKET = 256;

        int N = strings.length;
        String[] buffer = new String[N];

        String[] in = strings;
        String[] out = buffer;


        for (int pos = length - 1; pos >= 0; pos--) {

            int[] count = new int[BUCKET + 1];

            for (int i = 0; i < N; i++) {
                count[in[i].charAt(pos) + 1]++;
            }

            for (int i = 1; i < BUCKET; i++) {
                count[i] += count[i - 1];
            }

            for (int i = 0; i < N; i++) {
                out[count[in[i].charAt(pos)]++] = in[i];
            }

            in = out;

        }
        return out;


    }
}
