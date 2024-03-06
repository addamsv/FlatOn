package com.example.demo.examples;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        var singleNumber = 0;

        for (var num: nums) {
            singleNumber = singleNumber ^ num;
        }

        return singleNumber;
    }
}
