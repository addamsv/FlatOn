package com.example.demo.examples;

public class BinarySearch {
    /*
    * O(log n) runtime complexity
    */
    public static int searchInsert(int[] numbers, int target) {
        var hiIndex = 0;
        var loIndex = numbers.length - 1;
        var midIndex = 0;

        while (loIndex < hiIndex) {
            midIndex = (loIndex + hiIndex) / 2;

            if (numbers[midIndex] == target) {
                return midIndex;
            }

            if (numbers[midIndex] < target) {
                loIndex = midIndex + 1;
            }

            if (numbers[midIndex] > target) {
                hiIndex = midIndex - 1;
            }
        }

        return numbers[loIndex] >= target ? loIndex : loIndex + 1;
    }
}
