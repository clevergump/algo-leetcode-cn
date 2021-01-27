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
public class _9_My1 {


    /**
     * 将给定整数转换为字符串, 然后使用双指针法
     *
     * 执行用时: 12 ms
     * 内存消耗: 37.9 MB
     *
     * 时间复杂度 O(1): 十进制整数的位数有限(最多大概10位, 含符号11位  2147483647, -2147483648 的位数),
     *      双指针遍历, 所以时间复杂度 O(1)
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String strOfInput = String.valueOf(x);
        int rightestCharIndex = strOfInput.length() - 1;

        int leftPtr = 0;
        int rightPtr = rightestCharIndex;
        while (leftPtr < rightPtr) {
            char leftChar = strOfInput.charAt(leftPtr);
            char rightChar = strOfInput.charAt(rightPtr);
            if (leftChar != rightChar) {
                return false;
            }
            leftPtr++;
            rightPtr--;
        }
        return true;
    }
}
