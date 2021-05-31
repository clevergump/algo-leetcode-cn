package com.leetcodecn._1_easy;

import java.util.HashMap;

/**
 * HashMap, 使用了两遍for循环, 可优化为一遍for循环, 见 {@link _1_My2}
 */
public class _1_My1 {
    public int[] twoSum(int[] nums, int target) {
        // 因为 2 <= nums.length <= 103， 所以无需判断 null
        HashMap cache = initCache(nums);
        for (int i = 0; i < nums.length; i++) {
            int anotherNum = target - nums[i];
            Object hittedIndex = cache.get(anotherNum);
            // 要求数组中同一个元素不能使用两遍， 所以添加条件 i != (int)hittedIndex
            // 只能判断两个index不能相同，不能判断两个数值相同（因为index不同的两个数可能其数值相同，但这是符合题目要求的）
            if (hittedIndex != null && i != (int)hittedIndex) {
                return new int[]{i, (int) hittedIndex};
            }
        }
        return new int[]{};
    }

    private HashMap initCache(int[] nums) {
        HashMap map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map;
    }
}
