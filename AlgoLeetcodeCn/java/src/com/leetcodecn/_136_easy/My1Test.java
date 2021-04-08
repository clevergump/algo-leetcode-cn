package com.leetcodecn._136_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class My1Test {

    @Test
    void singleNumber() {
        Assertions.assertEquals(1, new My1().singleNumber(new int[]{1,2,3,2,3}));
        Assertions.assertEquals(1, new My1().singleNumber(new int[]{2,2,1}));
        Assertions.assertEquals(4, new My1().singleNumber(new int[]{4,1,2,1,2}));
    }
}