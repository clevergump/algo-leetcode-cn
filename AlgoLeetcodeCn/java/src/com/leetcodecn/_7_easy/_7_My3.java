package com.leetcodecn._7_easy;

public class _7_My3 {
    /**
     * 性能测试结果:
     * 执行用时： 1 ms
     * 内存消耗： 35.6 MB
     *
     *
     * 基于 {@link _7_My2#reverseInt(int)} 的逻辑做进一步简化或修改 (思想: 也是利用栈的 push pop)
     *
     * 1. 省略正负数各自的处理逻辑
     * 2. 省略对 Integer最小值的特殊处理
     * 3. 修改 while循环的判断条件, 由 >0 改为 != 0
     *
     * 因为负数的取模没有特殊的, 也是和正数那样直接 %10 即可取模
     *
     * @param original
     * @return
     */
    public static int reverseInt(int original) {
        int ret = 0;
        int tempRet = 0;
        while (original != 0) {
            // pop lowest bit
            int popedBit = original % 10;
            original /= 10;
            // push to lowest bit
            tempRet = tempRet * 10 + popedBit;

            // 判断是否越界, 是否超过Integer的最大值和最小值
            boolean isOverflow = (tempRet / 10) != ret;
            if (isOverflow) {
                return 0;
            }
            ret = tempRet;
        }
        return ret;
    }
}
