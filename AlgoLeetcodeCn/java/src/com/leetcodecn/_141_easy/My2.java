package com.leetcodecn._141_easy;


import com.leetcodecn.common.helper.ListNode;

public class My2 {
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
        /**
         * 将快指针的初始位置直接放到慢指针的前边，而不是二者初始位置重合， 就可以避免像 {@link My1#hasCycle}
         * 那样需要每次在 while循环里额外判断 isLoopRun
         */
        ListNode quick = head.next;
        ListNode slow = head;
        boolean ret = false;
        while (true) {
            if (quick.next == null || quick.next.next == null) {
                ret = false;
                break;
            }
            if (quick == slow){
                ret = true;
                break;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return ret;
    }
}