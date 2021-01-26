package com.leetcodecn._7_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _7_MyTest {

    @Test
    void reverseInt() {
        Assertions.assertEquals(11, _7_My.reverseInt(11));
        Assertions.assertEquals(123, _7_My.reverseInt(321));
        Assertions.assertEquals(2341, _7_My.reverseInt(1432));
        Assertions.assertEquals(54321, _7_My.reverseInt(12345));
        Assertions.assertEquals(-11, _7_My.reverseInt(-11));
        Assertions.assertEquals(-123, _7_My.reverseInt(-321));
        Assertions.assertEquals(-2341, _7_My.reverseInt(-1432));
        Assertions.assertEquals(-54321, _7_My.reverseInt(-12345));
        Assertions.assertEquals(0, _7_My.reverseInt(1534236469));
        Assertions.assertEquals(0, _7_My.reverseInt(Integer.MIN_VALUE));
        Assertions.assertEquals(0, _7_My.reverseInt(Integer.MAX_VALUE));
    }


    @Test
    void testMathAbs(){
        Assertions.assertEquals(Integer.MIN_VALUE, Math.abs(Integer.MIN_VALUE));
        Assertions.assertEquals(-2147483648, Math.abs(Integer.MIN_VALUE));
        Assertions.assertEquals(2147483647, Math.abs(Integer.MIN_VALUE + 1));
    }

    @Test
    void testGetDecimalBitsCnt () {
        Assertions.assertEquals(1, _7_My.getDecimalBitsCnt(0));
        Assertions.assertEquals(1, _7_My.getDecimalBitsCnt(7));
        Assertions.assertEquals(2, _7_My.getDecimalBitsCnt(10));
        Assertions.assertEquals(2, _7_My.getDecimalBitsCnt(67));
        Assertions.assertEquals(3, _7_My.getDecimalBitsCnt(100));
        Assertions.assertEquals(3, _7_My.getDecimalBitsCnt(245));
        Assertions.assertEquals(4, _7_My.getDecimalBitsCnt(1000));
        Assertions.assertEquals(4, _7_My.getDecimalBitsCnt(5656));
        Assertions.assertEquals(5, _7_My.getDecimalBitsCnt(10000));
        Assertions.assertEquals(5, _7_My.getDecimalBitsCnt(56234));

        Assertions.assertEquals(1, _7_My.getDecimalBitsCnt(-7));
        Assertions.assertEquals(2, _7_My.getDecimalBitsCnt(-10));
        Assertions.assertEquals(2, _7_My.getDecimalBitsCnt(-67));
        Assertions.assertEquals(3, _7_My.getDecimalBitsCnt(-100));
        Assertions.assertEquals(3, _7_My.getDecimalBitsCnt(-245));
        Assertions.assertEquals(4, _7_My.getDecimalBitsCnt(-1000));
        Assertions.assertEquals(4, _7_My.getDecimalBitsCnt(-5656));
        Assertions.assertEquals(5, _7_My.getDecimalBitsCnt(-10000));
        Assertions.assertEquals(5, _7_My.getDecimalBitsCnt(-56234));
    }
}