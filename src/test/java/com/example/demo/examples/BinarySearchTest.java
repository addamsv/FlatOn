package com.example.demo.examples;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {
    @Test
    void searchInsert1() {
        assertThat(BinarySearch.searchInsert(new int[]{1,3,5,6}, 5)).isEqualTo(2);
    }
    @Test
    void searchInsert2() {
        assertThat(BinarySearch.searchInsert(new int[]{1,3,5,6}, 2)).isEqualTo(1);
    }
    @Test
    void searchInsert3() {
        assertThat(BinarySearch.searchInsert(new int[]{1,3,5,6}, 7)).isEqualTo(4);
    }
    @Test
    void searchInsert4() {
        assertThat(BinarySearch.searchInsert(new int[]{1}, 1)).isEqualTo(0);
    }
}