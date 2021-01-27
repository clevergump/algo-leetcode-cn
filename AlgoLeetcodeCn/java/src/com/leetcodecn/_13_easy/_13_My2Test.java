package com.leetcodecn._13_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _13_My2Test {

    @Test
    void romanToInt() {
        Assertions.assertEquals(1, _13_My2.romanToInt("I"));
        Assertions.assertEquals(5, _13_My2.romanToInt("V"));
        Assertions.assertEquals(10, _13_My2.romanToInt("X"));
        Assertions.assertEquals(50, _13_My2.romanToInt("L"));
        Assertions.assertEquals(100, _13_My2.romanToInt("C"));
        Assertions.assertEquals(500, _13_My2.romanToInt("D"));
        Assertions.assertEquals(1000, _13_My2.romanToInt("M"));

        Assertions.assertEquals(4, _13_My2.romanToInt("IV"));
        Assertions.assertEquals(9, _13_My2.romanToInt("IX"));
        Assertions.assertEquals(40, _13_My2.romanToInt("XL"));
        Assertions.assertEquals(90, _13_My2.romanToInt("XC"));
        Assertions.assertEquals(400, _13_My2.romanToInt("CD"));
        Assertions.assertEquals(900, _13_My2.romanToInt("CM"));

        Assertions.assertEquals(3, _13_My2.romanToInt("III"));
        Assertions.assertEquals(58, _13_My2.romanToInt("LVIII"));
        Assertions.assertEquals(1994, _13_My2.romanToInt("MCMXCIV"));
    }
}