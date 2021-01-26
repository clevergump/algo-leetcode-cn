package com.leetcodecn._7_easy;

public class _7_My2 {

    /**
     * 性能测试结果:
     * 执行用时： 1 ms
     * 内存消耗： 35.6 MB
     *
     * 从原数中逐一pop最低位, 再逐一push到新数的最低位并向左移动
     *
     * @param original
     * @return
     */
    public static int reverseInt(int original) {
        // Integer.MIN_VALUE 取绝对值后, 没有与之对应的正数, 需要特殊处理
        if (original == Integer.MIN_VALUE) {
            return 0;
        }
        int multiply = original < 0 ? -1 : 1;
        // 转换为对应的正数
        original = Math.abs(original);


        int ret = 0;
        int tempRet = 0;
        while (original > 0) {
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
        return ret * multiply;
    }
}