package com.leetcodecn._1_easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 对{@link _1_My1} 的优化. 将两遍for循环优化为一遍for循环
 *
 */
public class _1_My2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int indexOfNum = 0; indexOfNum < nums.length; indexOfNum++) {
            int num = nums[indexOfNum];
            int numToPair = target - num;
            Integer indexOfNumToPair = valueIndexMap.get(numToPair);
            // indexOfNum != indexOfNumToPair： 只能判断两个index不相等, 而不能判断两个数值不相等
            if (valueIndexMap.containsKey(numToPair) && indexOfNum != indexOfNumToPair) {
                return new int[]{indexOfNum, indexOfNumToPair};
            }
            valueIndexMap.put(num, indexOfNum);
        }
        return new int[]{};
    }
}