package com.leetcodecn._38_easy;

/**
 * 递归的迭代法，
 * 参考  https://leetcode-cn.com/problems/count-and-say/solution/38-bao-shu-java-xun-huan-by-pphdsny/
 *
 * 执行用时：5 ms, 在所有 Java 提交中击败了45.64%的用户
 * 内存消耗：36.3 MB, 在所有 Java 提交中击败了40.56%的用户
 */
public class _38_My2 {
    public String countAndSay(int n) {
        if (n < 1 || n > 30) {
            throw new Error("n must be between 1 and 30.");
        }
        if (n == 1) {
            return "1";
        }
        String prevStr = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder curStrBuilder = new StringBuilder();
            int prevLength = prevStr.length();
            char curChar = prevStr.charAt(0);
            int curCharCnt = 1;
            for (int indexOfCharInPrevStr = 1; indexOfCharInPrevStr < prevLength; indexOfCharInPrevStr++) {
                char curTraversedChar = prevStr.charAt(indexOfCharInPrevStr);
                if (curTraversedChar == curChar){
                    curCharCnt ++;
                } else {
                    curStrBuilder.append(curCharCnt).append(curChar);
                    curChar = curTraversedChar;
                    curCharCnt = 1;
                }
            }
            curStrBuilder.append(curCharCnt).append(curChar);
            prevStr = curStrBuilder.toString();
        }
        return prevStr;
    }
}
