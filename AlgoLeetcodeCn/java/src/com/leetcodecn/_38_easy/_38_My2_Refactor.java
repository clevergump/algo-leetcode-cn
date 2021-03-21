package com.leetcodecn._38_easy;

/**
 * 递归的迭代法，
 * 参考  https://leetcode-cn.com/problems/count-and-say/solution/38-bao-shu-java-xun-huan-by-pphdsny/
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了97.31%的用户
 * 内存消耗：36.2 MB, 在所有 Java 提交中击败了48.09%的用户
 */
public class _38_My2_Refactor {
    public String countAndSay(int n) {
        if (n < 1 || n > 30) {
            throw new Error("n must be between 1 and 30.");
        }
        if (n == 1) {
            return "1";
        }
        String prevStr = "1";
        for (int i = 2; i <= n; i++) {
            // 将计算出来的当前的字符串， 作为下一轮迭代的“ ”“"前一个字符串"
            prevStr = calcCurStr(prevStr);
        }
        return prevStr;
    }

    /**
     * 基于前一个字符串， 来计算当前字符串
     * @param prevStr 当前要计算的字符串的前一个字符串
     * @return
     */
    private String calcCurStr(String prevStr) {
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
        return curStrBuilder.toString();
    }
}
