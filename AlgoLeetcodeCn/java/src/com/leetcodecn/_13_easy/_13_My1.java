package com.leetcodecn._13_easy;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 13. 罗马数字转整数
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * 1. I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * 2. X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * 3. C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 *
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 *
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * 提示：
 *
 * 1. 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * 2. IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 3. 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 *
 */
public class _13_My1 {

    /**
     * 耗时: 10 ms
     * 内存: 39.1 MB
     *
     * @param roman
     * @return
     */
    public static int romanToInt(String roman) {
        if (roman == null) {
            throw new IllegalArgumentException("roman cannot be null.");
        }

        Map<String, Integer> specialPairs = new HashMap<String, Integer>(6);
        specialPairs.put("IV", 4);
        specialPairs.put("IX", 9);
        specialPairs.put("XL", 40);
        specialPairs.put("XC", 90);
        specialPairs.put("CD", 400);
        specialPairs.put("CM", 900);

        Map<String, Integer> normalPairs = new HashMap<String, Integer>(7);
        normalPairs.put("I",    1);
        normalPairs.put("V",    5);
        normalPairs.put("X",   10);
        normalPairs.put("L",   50);
        normalPairs.put("C",  100);
        normalPairs.put("D",  500);
        normalPairs.put("M", 1000);

        int maxCharIndex = roman.length() - 1;
        int ret = 0;
        int ptr = 0;
        while (ptr <= maxCharIndex) {
            if (ptr < maxCharIndex) {
                String curTwoStr = roman.substring(ptr, ptr + 2);
                if (specialPairs.containsKey(curTwoStr)) {
                    ret += specialPairs.get(curTwoStr);
                    ptr += 2;
                    continue;
                }
            }
            String curSingleStr = roman.substring(ptr, ptr+1);
            if (normalPairs.containsKey(curSingleStr)){
                ret += normalPairs.get(curSingleStr);
            }
            ptr++;
        }

        return ret;
    }
}
