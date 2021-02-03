package com.leetcodecn._21_easy;


/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1. 两个链表的节点数目范围是 [0, 50]
 * 2. -100 <= Node.val <= 100
 * 3. l1 和 l2 均按 非递减顺序 排列
 * <p>
 * <p>
 * Definition for singly-linked list.
 *
 * public class ListNode {
 *      int val;
 *      ListNode next;
 *
 *      ListNode() {}
 *
 *      ListNode(int val) {
 *          this.val = val;
 *      }
 *
 *      ListNode(int val, ListNode next) {
 *          this.val = val; this.next = next;
 *      }
 * }
 *
 */
public class _21Recursion {
    /**
     *
     * 执行用时： 1 ms
     * 内存消耗： 38 MB
     *
     * 递归写法. 带哨兵节点的迭代写法见 {@link Best_21IterationWithGuard}
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}