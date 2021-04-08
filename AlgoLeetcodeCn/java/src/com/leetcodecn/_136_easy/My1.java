package com.leetcodecn._136_easy;

/**
 * 位运算. 一个数与0异或后的数值还是它本身
 *
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了13.63%的用户
 *
 */
public class My1 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num: nums) {
            ret ^= num;
        }
        return ret;
    }
}