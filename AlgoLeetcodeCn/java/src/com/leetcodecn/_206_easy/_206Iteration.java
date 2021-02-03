package com.leetcodecn._206_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 206. 反转链表
 * 反转一个单链表.
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 *
 * Definition for singly-linked list.
 *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 *
 */
public class _206Iteration {

    /**
     * 相关简写的解释:
     * rH:  headOfReversedList    已反转的链表的头节点
     * uH:  headOfUnreversedList  未反转的链表的头节点
     */
    private ListNode rH;
    private ListNode uH;

    /**
     * 迭代法
     *
     * 执行用时： 0 ms
     * 内存消耗： 38.1 MB
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head == null) return null;
        ListNode ret = null;
        ListNode dummy = new ListNode(-1);
        rH = dummy;
        uH = head;
        while (uH != null) {
            ret = uH;
            reverseOneNode();
        }
//        dummy = null;
        head.next = null;
        return ret;
    }

    /**
     * 反转一个节点
     */
    private void reverseOneNode() {
        ListNode nextUH = uH.next;
        uH.next = rH;
        rH = uH;
        uH = nextUH;
    }

//    /**
//     * 反转一个节点, 并返回未反转的链表的表头节点
//     * @param uH
//     * @param rH
//     * @return 未反转的链表的表头节点
//     */
//    private ListNode reverseOneNode(ListNode uH, ListNode rH) {
//        ListNode nextUH = uH.next;
//        uH.next = rH;
//        rH = uH;
//        return nextUH;
//    }

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

        public List<Integer> getValuesArr(){
            List<Integer> ret = new ArrayList<>();
            ListNode curNode = this;
            while (curNode != null) {
                ret.add(curNode.val);
                curNode = curNode.next;
            }
            return ret;
        }
    }
}