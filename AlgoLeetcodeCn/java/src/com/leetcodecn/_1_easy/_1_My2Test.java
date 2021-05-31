package com.leetcodecn._1_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _1_My2Test {

    @Test
    public void twoSum() {
        // 不能是 new int[]{0, 0}
        Assertions.assertTrue(
                arrayEquals(new _1_My2().twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}, new int[]{2, 1})
        );

        Assertions.assertArrayEquals(new _1_My2().twoSum(new int[]{1, 2, 3, 4}, 10), new int[]{});
        Assertions.assertTrue(
                arrayEquals(new _1_My2().twoSum(new int[]{1, 2}, 3), new int[]{0, 1}, new int[]{1, 0})
        );
        Assertions.assertTrue(
                arrayEquals(new _1_My2().twoSum(new int[]{1, 2, 3, 4}, 4), new int[]{0, 2}, new int[]{2, 0})
        );
        Assertions.assertTrue(
                arrayEquals(new _1_My2().twoSum(new int[]{-4, 0, 4}, 0), new int[]{0, 2}, new int[]{2, 0})
        );
    }

    private boolean arrayEquals(int[] arr1, int[]... arrGroupToMatch) {
        if (arr1 == null) return false;
        if (arrGroupToMatch == null) return false;
        for (int i = 0; i < arrGroupToMatch.length; i++) {
            if (Arrays.equals(arr1, arrGroupToMatch[i])) {
                return true;
            }
        }
        return false;
    }
}