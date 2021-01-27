package com.leetcodecn._9_easy;


/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class _9_My2_Official {

    /**
     *
     * 此算法和官方算法思路一致.
     * https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
     *
     * 将原数值反转, 但为了避免反转后数值溢出, 所以只需反转一半即可进行比较, 得出结论. 但需要处理一些特殊情况:
     * 1. 负数
     * 2. 原数以0结尾 (包括两种情况: 0本身, 以0结尾的正数)
     * 此后根据原数的十进制位数是奇数还是偶数来决定对比反转后原数剩余的部分和已经完成反转的部分二者之间的对比策略.
     *
     * 执行用时: 8 ms
     * 内存消耗: 37.7 MB
     *
     * @param original
     * @return
     */
    public static boolean isPalindrome(int original) {
        if (original < 0) {
            return false;
        }
        // [易遗漏]
        if (original == 0) {
            return true;
        }
        // [易遗漏] 对于非0但以0结尾的整数, 要做特殊处理, 不能流入下面的循环中. 因为以0结尾在反转给 halfReversed 后, 0被放到最高位,
        // 整数前边的0会被自动忽略掉, 等效于原数就没有包含0. 所以要特殊处理
        if (original % 10 == 0) {
            return false;
        }

        int halfOriginal = original;
        int halfReversed = 0;

        while (halfOriginal > halfReversed) {
            int popBit = halfOriginal % 10;
            halfOriginal /= 10;
            halfReversed = halfReversed * 10 + popBit;
        }
        // 原数是偶数位
        if (halfOriginal == halfReversed) {
            return true;
        }
        // 原数是奇数位, halfOriginal < halfReversed
        // 移除最低位
        halfReversed /= 10;
        return halfOriginal == halfReversed;
    }
}
