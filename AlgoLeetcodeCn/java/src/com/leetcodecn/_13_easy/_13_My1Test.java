package com.leetcodecn._13_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _13_My1Test {


    /**
     * * 示例 1:
     * * 输入: "III"
     * * 输出: 3
     * *
     * * 示例 2:
     * * 输入: "IV"
     * * 输出: 4
     * *
     * * 示例 3:
     * * 输入: "IX"
     * * 输出: 9
     * *
     * * 示例 4:
     * * 输入: "LVIII"
     * * 输出: 58
     * * 解释: L = 50, V= 5, III = 3.
     * *
     * * 示例 5:
     * * 输入: "MCMXCIV"
     * * 输出: 1994
     * * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * <p>
     * <p>
     * "IV" -> 4
     * "IX" -> 9
     * "XL" -> 40
     * "XC" -> 90
     * "CD" -> 400
     * "CM" -> 900
     * <p>
     * "I" ->    1
     * "V" ->    5
     * "X" ->   10
     * "L" ->   50
     * "C" ->  100
     * "D" ->  500
     * "M" -> 1000
     */
    @Test
    void romanToInt() {
        Assertions.assertEquals(1, _13_My1.romanToInt("I"));
        Assertions.assertEquals(5, _13_My1.romanToInt("V"));
        Assertions.assertEquals(10, _13_My1.romanToInt("X"));
        Assertions.assertEquals(50, _13_My1.romanToInt("L"));
        Assertions.assertEquals(100, _13_My1.romanToInt("C"));
        Assertions.assertEquals(500, _13_My1.romanToInt("D"));
        Assertions.assertEquals(1000, _13_My1.romanToInt("M"));

        Assertions.assertEquals(4, _13_My1.romanToInt("IV"));
        Assertions.assertEquals(9, _13_My1.romanToInt("IX"));
        Assertions.assertEquals(40, _13_My1.romanToInt("XL"));
        Assertions.assertEquals(90, _13_My1.romanToInt("XC"));
        Assertions.assertEquals(400, _13_My1.romanToInt("CD"));
        Assertions.assertEquals(900, _13_My1.romanToInt("CM"));

        Assertions.assertEquals(3, _13_My1.romanToInt("III"));
        Assertions.assertEquals(58, _13_My1.romanToInt("LVIII"));
        Assertions.assertEquals(1994, _13_My1.romanToInt("MCMXCIV"));
    }

    @Test
    void testStrReplace() {
        Assertions.assertEquals("aa", "ABAB".replace("AB", "a"));
    }
}