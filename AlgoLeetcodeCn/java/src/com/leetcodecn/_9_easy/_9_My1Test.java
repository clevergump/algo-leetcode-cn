package com.leetcodecn._9_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _9_My1Test {

    @Test
    void isPalindrome() {
        Assertions.assertEquals(true, _9_My1.isPalindrome(0));
        Assertions.assertEquals(false, _9_My1.isPalindrome(Integer.MAX_VALUE)); // 2147483647
        Assertions.assertEquals(false, _9_My1.isPalindrome(Integer.MIN_VALUE)); // -2147483648
        Assertions.assertEquals(false, _9_My1.isPalindrome(-1)); // -2147483648
        Assertions.assertEquals(true, _9_My1.isPalindrome(1234321)); // -2147483648
        Assertions.assertEquals(true, _9_My1.isPalindrome(12344321)); // -2147483648
        Assertions.assertEquals(false, _9_My1.isPalindrome(1234564321)); // -2147483648

        Assertions.assertEquals(false, _9_My1.isPalindrome(100));
    }
}