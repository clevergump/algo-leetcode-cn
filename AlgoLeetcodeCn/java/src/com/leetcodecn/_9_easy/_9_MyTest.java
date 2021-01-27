package com.leetcodecn._9_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _9_MyTest {

    @Test
    void isPalindrome() {
        Assertions.assertEquals(true, _9_My.isPalindrome(0));
        Assertions.assertEquals(false, _9_My.isPalindrome(Integer.MAX_VALUE)); // 2147483647
        Assertions.assertEquals(false, _9_My.isPalindrome(Integer.MIN_VALUE)); // -2147483648
        Assertions.assertEquals(false, _9_My.isPalindrome(-1)); // -2147483648
        Assertions.assertEquals(true, _9_My.isPalindrome(1234321)); // -2147483648
        Assertions.assertEquals(true, _9_My.isPalindrome(12344321)); // -2147483648
        Assertions.assertEquals(false, _9_My.isPalindrome(1234564321)); // -2147483648

        Assertions.assertEquals(false, _9_My.isPalindrome(100));
    }
}