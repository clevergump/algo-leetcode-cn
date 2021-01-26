package com.leetcodecn._7_easy;

/**
 * 7. 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ,返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1], 就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：x = Integer.MIN_VALUE  // -2147483648
 * 输出：0
 * <p>
 * <p>
 * 示例 5：
 * 输入：x = Integer.MAX_VALUE  // 2147483647
 * 输出：0
 * <p>
 *
 * <p>
 * 提示：
 * <p>
 * -2^31 <= x <= 2^31 - 1
 */
public class _7_My1 {

    /**
     * 性能测试结果:
     * 时间: 2 ms
     * 内存: 35.6 MB
     *
     * @param original
     * @return
     */
    public static int reverseInt(int original) {
        // 因为对 Integer.MIN_VALUE 使用 Math.abs 计算出来的不是正数, 而是该最小值本身. 详情见 API说明.
        if (original == Integer.MIN_VALUE) {
            return 0;
        }

        if (original == 0) {
            return 0;
        }
        int mulitiply = original < 0 ? -1 : 1;
        // 绝对值
        int absOriginal = Math.abs(original);


        int bitsCnt = getDecimalBitsCnt(absOriginal);
        int maxIteration = bitsCnt - 1;
        long tempSum = 0;
        for (int iteration = maxIteration; iteration >= 0; iteration--) {
            tempSum += absOriginal / (long) Math.pow(10, iteration) % 10 * (long) Math.pow(10, maxIteration - iteration);
        }
        long ret = tempSum * mulitiply;
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ret;
    }

    /**
     * 获取给定数按照十进制显示时的位数
     *
     * @param original
     */
    public static int getDecimalBitsCnt(int original) {
//         Integer.MAX_VALUE (2147483647) 十进制为10位
        int left = Math.abs(original);
        int bitsCnt = 0;
        while (left > 10) {
            left = left / 10;
            bitsCnt++;
        }
        return left == 10 ? bitsCnt + 2 : bitsCnt + 1;
    }
}