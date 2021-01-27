package com.leetcodecn._1_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _1_OfficialTest {

    @Test
    void findIndexesOfTwo() {
        int[] indexes = _1_Official.findIndexesOfTwo(new int[]{1, 2, 3, 4}, 6);
        Assertions.assertTrue(
                Arrays.equals(new int[]{1, 3}, indexes) || Arrays.equals(new int[]{3, 1}, indexes)
        );

//        int[] ints = {3, 1};
//        Assertions.assertArrayEquals(ints, indexes);
    }
}