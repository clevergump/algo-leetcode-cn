package com.leetcodecn._7_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _7_My3Test {

    @Test
    void reverseInt() {
        Assertions.assertEquals(11, _7_My3.reverseInt(11));
        Assertions.assertEquals(123, _7_My3.reverseInt(321));
        Assertions.assertEquals(2341, _7_My3.reverseInt(1432));
        Assertions.assertEquals(54321, _7_My3.reverseInt(12345));
        Assertions.assertEquals(-11, _7_My3.reverseInt(-11));
        Assertions.assertEquals(-123, _7_My3.reverseInt(-321));
        Assertions.assertEquals(-2341, _7_My3.reverseInt(-1432));
        Assertions.assertEquals(-54321, _7_My3.reverseInt(-12345));
        Assertions.assertEquals(0, _7_My3.reverseInt(1534236469));
        Assertions.assertEquals(0, _7_My3.reverseInt(Integer.MIN_VALUE));
        Assertions.assertEquals(0, _7_My3.reverseInt(Integer.MAX_VALUE));
    }

    /**
     * 测试取模运算, 结论: 负数也可以像正数那样直接取模
     */
    @Test
    void testGetMode(){
        Assertions.assertEquals(-8, Integer.MIN_VALUE % 10);
        Assertions.assertEquals(7, Integer.MAX_VALUE % 10);
    }
}