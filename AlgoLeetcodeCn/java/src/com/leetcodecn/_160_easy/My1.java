package com.leetcodecn._160_easy;

import com.leetcodecn.common.helper.ListNode;

/**
 * 双指针法
 *
 * 参考官方题解的思路如下:
 * 创建两个指针 pA 和 pB, 分别初始化为链表 A 和 B 的头结点, 然后让它们向后逐结点遍历.
 * 当 pA 到达链表的尾部时, 将它重定位到链表 B 的头结点; 类似的, 当 pB 到达链表的尾部时, 将它重定位到链表 A 的头结点.
 * 若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点. 如果两个链表存在相交，它们末尾的结点必然相同,
 * 因此当 pA/pB 到达链表结尾时，记录下链表 A/B 对应的元素. 若最后元素不相同，则两个链表不相交.
 *
 *
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.1 MB, 在所有 Java 提交中击败了81.65%的用户
 */
public class My1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        boolean isAInAnotherList = false;
        boolean isBInAnotherList = false;

        while (ptrA != ptrB) {
            if (ptrA.next == null && !isAInAnotherList) {
                ptrA = headB;
                isAInAnotherList = true;
            } else {
                ptrA = ptrA.next;
            }

            if (ptrB.next == null && !isBInAnotherList) {
                ptrB = headA;
                isBInAnotherList = true;
            } else {
                ptrB = ptrB.next;
            }
        }
        return ptrA;
    }
}