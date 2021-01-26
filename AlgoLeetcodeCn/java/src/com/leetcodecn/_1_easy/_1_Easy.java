package com.leetcodecn._1_easy;


import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 * 提示：
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1_Easy {

    public static int[] findIndexesOfTwo(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums cannot be null.");
        }
        int numsCnt = nums.length;
        if (numsCnt < 2) {
            throw new IllegalArgumentException("nums must contains at least two elements.");
        }
        Map<Integer, Integer> valueIndexCache = new HashMap<Integer, Integer>(numsCnt - 1);
        for (int curIndex = 0; curIndex < numsCnt; curIndex++) {
            int curValue = nums[curIndex];
            int valueToFind = target - curValue;
            if (valueIndexCache.containsKey(valueToFind)) {
                // 必定不是 null, 所以可以直接 unboxing
                int indexToFind = valueIndexCache.get(valueToFind);
                return new int[]{curIndex, indexToFind};
            }
            valueIndexCache.put(curValue, curIndex);
        }
        throw new IllegalArgumentException("Cannot find the proper two elements in the nums array for the target.");
    }
}
