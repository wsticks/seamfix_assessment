package com.seamfix.java_assesment.algorithim;

import java.util.Arrays;

public class AlgoTest {

    public static void main(String[] args) {
        System.err.println(warning(9, 5, new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}));
    }

    public static int warning(int k, int l, int[] numbers) {
        int count = 0;
        String mediancheck = l % 2 == 0 ? "even" : "odd";
        for (int i = l; i < k; i++) {
            int[] subNum = Arrays.copyOfRange(numbers, i-l, i);
            Arrays.sort(subNum);
            float median;
            if(mediancheck.equals("odd")) {
                median = subNum[l/2];
            }else{
                median = (float)(subNum[l/2] + subNum[l/2-1])/2;
            }
            if(numbers[i] >= (2 * median)) {
                count++;
            }
        }
        return count;
    }
}
