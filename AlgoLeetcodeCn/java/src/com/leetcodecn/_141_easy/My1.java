package com.leetcodecn._141_easy;


import com.leetcodecn.common.helper.ListNode;

public class My1 {
    /**
     * 快慢指针法
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了 54.97% 的用户
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 0个节点
        if (head == null) return false;
        // 一个节点
        if (head.next == null) return false;
        ListNode quick = head;
        ListNode slow = head;
        boolean isLoopRun = false;
        boolean ret = false;
        while (true) {
            if (quick.next == null || quick.next.next == null) {
                ret = false;
                break;
            }
            /**
             * 由于快慢指针的初始位置重合，所以每次while循环就必须额外判断变量 isLoopRun.
             * 避免每次循环都要判断该变量的解法是，直接设置快指针的初始位置在慢指针的前边,
             * 见 {@link My2#hasCycle}
             */
            if (quick == slow && isLoopRun){
                ret = true;
                break;
            }
            slow = slow.next;
            quick = quick.next.next;
            isLoopRun = true;
        }
        return ret;
    }
}