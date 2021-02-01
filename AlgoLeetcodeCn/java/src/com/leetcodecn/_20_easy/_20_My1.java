package com.leetcodecn._20_easy;


/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * <p>
 * 补充by:
 * 官方题解有误. 题目并没有要求字符串里必须左右括号要一一对应, 而是只要求所有的左括号都要有对应的右括号与之对应,
 * 所以当只有右括号未被匹配时, 按照题目描述来说也是 true的.
 * 例如:
 * ")))()" true
 * ")))[()]))"  true
 */
public class _20_My1 {

    private char[] container;
    private int containerNextIndex = 0;

    /**
     * 官方判定必须左右括号要完全匹配, 不能仅保证左括号匹配, 所以为了能提交, 就只能改为下面的写法, 即:
     * ")))()"      认为是 false, 不是true
     * ")))[()]))"  认为是 false, 不是true
     *
     * 执行用时：1 ms,    在所有 Java 提交中击败了99.26%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了34.52%的用户
     *
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        initContainer(s.length());
        // 字符数量为奇数
        if (s.length() % 2 == 1) return false;
        for (int i = 0; i < s.length(); i++) {
            char curIteratedChar = s.charAt(i);
            if (isRightChar(curIteratedChar)) {
                if (isContainerEmpty()) {
                    return false;
                }
                char topOfStack = pop();
                if (isMatch(topOfStack, curIteratedChar)) {
                    continue;
                }
                return false;
            } else if (isLeftChar(curIteratedChar)) {
                push(curIteratedChar);
            } else {
                throw new IllegalArgumentException("Current char is invalid.");
            }
        }
        return isContainerEmpty();
    }

    private void initContainer(int length) {
        container = new char[length];
    }

    private boolean isMatch(char charExpectedLeft, char charExpectedMatchedRight) {
        if (charExpectedLeft == '(' && charExpectedMatchedRight == ')') return true;
        if (charExpectedLeft == '[' && charExpectedMatchedRight == ']') return true;
        if (charExpectedLeft == '{' && charExpectedMatchedRight == '}') return true;
        return false;
    }

    private char pop() {
        containerNextIndex--;
        char topOfStack = container[containerNextIndex];
        return topOfStack;
    }

    private void push(char nextChar) {
        container[containerNextIndex] = nextChar;
        containerNextIndex++;
    }

    private boolean isContainerEmpty() {
        return containerNextIndex == 0;
    }

    private boolean isLeftChar(char curChar) {
        return '(' == curChar
                || '[' == curChar
                || '{' == curChar
                ;
    }

    private boolean isRightChar(char curChar) {
        return ')' == curChar
                || ']' == curChar
                || '}' == curChar
                ;
    }
}



//public class _20_My1 {
//
//    private char[] container = new char[10];
//    private int containerNextIndex = 0;
//
//    public boolean isValid(String s) {
//        // 1 <= s.length <= 104
//        for (int i = 0; i < s.length(); i++) {
//            char curIteratedChar = s.charAt(i);
//            if (isRightChar(curIteratedChar)) {
//                if (isContainerEmpty()) {
//                    continue;
//                }
//                char topOfStack = pop();
//                if (isMatch(topOfStack, curIteratedChar)) {
//                    continue;
//                }
//                return false;
//            } else if (isLeftChar(curIteratedChar)) {
//                push(curIteratedChar);
//            } else {
//                throw new IllegalArgumentException("Current char is invalid.");
//            }
//        }
//        return isContainerEmpty();
//    }
//
//    private boolean isMatch(char charExpectedLeft, char charExpectedMatchedRight) {
//        if (charExpectedLeft == '(' && charExpectedMatchedRight == ')') return true;
//        if (charExpectedLeft == '[' && charExpectedMatchedRight == ']') return true;
//        if (charExpectedLeft == '{' && charExpectedMatchedRight == '}') return true;
//        return false;
//    }
//
//    private char pop() {
//        containerNextIndex--;
//        char topOfStack = container[containerNextIndex];
//        return topOfStack;
//    }
//
//    private void push(char nextChar) {
//        container[containerNextIndex] = nextChar;
//        containerNextIndex++;
//    }
//
//
//    private boolean isContainerEmpty() {
//        return containerNextIndex == 0;
//    }
//
//
//    private boolean isLeftChar(char curChar) {
//        return '(' == curChar
//                || '[' == curChar
//                || '{' == curChar
//                ;
//    }
//
//    private boolean isRightChar(char curChar) {
//        return ')' == curChar
//                || ']' == curChar
//                || '}' == curChar
//                ;
//    }
//}
