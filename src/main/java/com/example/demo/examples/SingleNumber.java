package com.example.demo.examples;
import java.util.Arrays;

public class SingleNumber {
    public static int singleNumber(int[] numbers) {
        var singleNumber = 0;

        for (var num: numbers) {
            singleNumber = singleNumber ^ num;
        }

        return singleNumber;
    }
    public static int singleNumberStream(int[] numbers) {
        return Arrays.stream(numbers).reduce(0, (x, y) -> x ^ y);
    }
}
