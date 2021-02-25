package com.leetcodecn._58_easy;

/**
 *
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 *
 * 输入：s = " "
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 *
 */
public class _58_ReverseTraversal1_NotBest {

    /**
     * 反向遍历. 通过增加前缀空格作为哨兵, 减少了分析的情况种类. 但当前算法的思维复杂度较高, 比 {@link _58_ReverseTraversal2_Best} 高,
     * 当前算法的细节稍微不注意就容易出错, 而 {@link _58_ReverseTraversal2_Best} 的算法更不容易出错. 所以推荐使用
     * {@link _58_ReverseTraversal2_Best}的算法.
     *
     * 1ms
     * 37MB
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s == null) return 0;

        String prefixSpaceGuard = " ";
        // 添加前缀哨兵, 简化情况的数量
        s = prefixSpaceGuard + s;

        // 此时字符串一定包含有字符, 但可能包含的全部是空格
        // 为字符串添加一个空格, 作为哨兵前缀.
        int length = s.length();
        if (length == 0) return 0;
        int indexOfLastLetter = -1;
        int indexOfNearestSpaceBeforeLastWord = -1;

        for (int i = length - 1; i >= 0; i--) {
            boolean isCurCharLetter = ' ' != s.charAt(i);
            boolean isLastLetterAssigned = indexOfLastLetter > 0;
            boolean isNearestSpaceBeforeLastWordAssigned = indexOfNearestSpaceBeforeLastWord > 0;
            // 当前遇到了字母, 并且是首次遇到字母
            if (isCurCharLetter && !isLastLetterAssigned) {
                indexOfLastLetter = i;
            }
            // 先前已经遇到过字母了, 并且当前遇到了空格, 并且是遇到过字母后的首次遇到空格
            else if (isLastLetterAssigned && !isCurCharLetter && !isNearestSpaceBeforeLastWordAssigned) {
                indexOfNearestSpaceBeforeLastWord = i;
                // 可以提前结束遍历了
                break;
            }
        }
        return indexOfLastLetter - indexOfNearestSpaceBeforeLastWord;
    }
}