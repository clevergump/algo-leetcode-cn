package com.leetcodecn._7_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _7_My1OptimizeTest {

    @Test
    void reverseInt() {
        Assertions.assertEquals(11, _7_My2.reverseInt(11));
        Assertions.assertEquals(123, _7_My2.reverseInt(321));
        Assertions.assertEquals(2341, _7_My2.reverseInt(1432));
        Assertions.assertEquals(54321, _7_My2.reverseInt(12345));
        Assertions.assertEquals(-11, _7_My2.reverseInt(-11));
        Assertions.assertEquals(-123, _7_My2.reverseInt(-321));
        Assertions.assertEquals(-2341, _7_My2.reverseInt(-1432));
        Assertions.assertEquals(-54321, _7_My2.reverseInt(-12345));
        Assertions.assertEquals(0, _7_My2.reverseInt(1534236469));
        Assertions.assertEquals(0, _7_My2.reverseInt(Integer.MIN_VALUE));
        Assertions.assertEquals(0, _7_My2.reverseInt(Integer.MAX_VALUE));
    }
}