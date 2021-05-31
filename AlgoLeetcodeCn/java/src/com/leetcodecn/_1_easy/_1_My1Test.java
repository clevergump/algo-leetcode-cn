package com.leetcodecn._1_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _1_MyTest {

    @Test
    public void twoSum() {
        // 不能是 new int[]{0, 0}
        Assertions.assertArrayEquals(new _1_My().twoSum(new int[]{3,2,4}, 6), new int[]{1,2});


        Assertions.assertArrayEquals(new _1_My().twoSum(new int[]{1,2,3,4}, 10), null);
        Assertions.assertArrayEquals(new _1_My().twoSum(new int[]{1,2}, 3), new int[]{0, 1});
        Assertions.assertArrayEquals(new _1_My().twoSum(new int[]{1,2,3,4}, 4), new int[]{0, 2});
        Assertions.assertArrayEquals(new _1_My().twoSum(new int[]{-4, -3, -2, -1, 0, 1,2,3,4}, 0), new int[]{0, 8});
    }
}
