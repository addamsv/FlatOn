package com.example.demo.examples;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SingleNumberTest {
    @Test
    void singleNumber1() {
        assertThat(SingleNumber.singleNumber(new int[]{2,2,1})).isEqualTo(1);
    }
    @Test
    void singleNumber2() {
        assertThat(SingleNumber.singleNumber(new int[]{4,1,2,1,2})).isEqualTo(4);
    }
    @Test
    void singleNumber3() {
        assertThat(SingleNumber.singleNumber(new int[]{1})).isEqualTo(1);
    }
}