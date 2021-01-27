package com.leetcodecn._13_easy;


/**
 * 13. 罗马数字转整数
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * 1. I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * 2. X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * 3. C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * <p>
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1. 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * 2. IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 3. 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 */
public class _13_My3 {

    /**
     * 等效变换法. 将特殊特征的字符转换为普通特征字符
     *
     * 和 {@link _13_My2#romanToInt(String)} 的思想完全相同, 差异仅是: 将其中的 switch..case 中匹配的
     * 数据类型由字符串String更改为 char, 更省时省内存
     *
     * 时间: 6 ms
     * 空间: 38.6 MB
     *
     * @see 另一种等效的思路见 {@link _13_My4}
     *
     * @param roman
     * @return
     */
    public static int romanToInt(String roman) {
        if (roman == null) {
            throw new IllegalArgumentException("roman cannot be null.");
        }

        int ret = 0;
        roman = roman.replace("IV", "a")
                .replace("IX", "b")
                .replace("XL", "c")
                .replace("XC", "d")
                .replace("CD", "e")
                .replace("CM", "f")
        ;

        int length = roman.length();
        for (int i = 0; i < length; i++) {
            char curBitChar = roman.charAt(i);
            ret += getBitValue(curBitChar);
        }
        return ret;
    }

    private static int getBitValue(char bitStr) {
        switch (bitStr) {
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        throw new IllegalArgumentException("bitStr is unsupported roman char.");
    }
}
