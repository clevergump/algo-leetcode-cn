package com.leetcodecn._234_easy;


import com.leetcodecn.common.helper.ListNode;

/**
 * 链表反转法, 比该算法思路更清晰的算法见 {@link My1Optimize}
 *
 * 9 ms, 在所有 Java 提交中击败了 21.91% 的用户
 * 56.6 MB, 在所有 Java 提交中击败了 5.04% 的用户
 *
 * 该算法耗时的地方主要是:
 * 1. 专门遍历一遍仅用于查找尾节点
 * 2. 专门遍历一遍仅用于计算链表的节点总数以便据此计算尾节点的 index
 * 总结: 虽然时间复杂度是O(n), 但遍历的次数过多, 导致耗时较多
 *
 * 改进上述耗时的做法:
 * 1. 查找中间节点的算法, 可以由 "遍历全部n个元素" 改善为 "快慢指针各自运行从而只需遍历n/2个元素", 从而节省一半的时间
 * 1. 查找到中间节点后, 解题思想仍是双指针双向遍历法, 但遍历的方向由"从两端向中间遍历"改为"从中间向两边遍历", 这样先前的如下4句算法:
 *             head = head.next;
 *             tail = tail.next;
 *             headIndex++;
 *             tailIndex--;
 *  可以剔除掉对 index的自增自减操作了, while循环的条件改为直接判断 head, tail是否为null, 使得每次遍历过程都能节省index自增自减的耗时.
 *
 *  另外, 该算法的API设计不够优雅, 导致无法复用, 例如: {@link #reverseLinkedList} 的参数列表应该设计为仅有一个参数(即: 单链表的头节点)
 *
 *
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode() {}
 *     public ListNode(int val) { this.val = val; }
 *     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class My1 {

    /** 链表的尾节点 */
    private static ListNode tailNode = null;
    /** 链表节点数量 */
    private static int countOfNodes;

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        countOfNodes = getNodesCount(head);
        int midOrFormerMidIndex = getMidOrFormerMidIndex(countOfNodes);
        reverseLinkedList(head, midOrFormerMidIndex);
        return traversalFromBothEnds(head, tailNode);
    }

    /**
     * 双指针双端遍历法
     * @param head 头指针
     * @param tail 尾指针
     * @return
     */
    private boolean traversalFromBothEnds(ListNode head, ListNode tail) {
        int headIndex = 0;
        int tailIndex = countOfNodes - 1;
        while (headIndex < tailIndex) {
            int headValue = head.val;
            int tailValue = tail.val;
            if (headValue != tailValue) {
                return false;
            }
            head = head.next;
            tail = tail.next;
            headIndex++;
            tailIndex--;
        }
        return true;
    }

    /**
     * 获取链表中间节点的下标.
     * @param nodesCount
     * @return 如果链表节点数量为奇数, 则返回中间节点的index. 当节点数量为偶数时, 是中间两个节点中靠前面的那个节点的index
     */
    static int getMidOrFormerMidIndex(int nodesCount) {
        // 节点个数是否是奇数
        boolean isOdd = nodesCount % 2 == 1;
        int midIndex = nodesCount / 2;
        // 节点数量为奇数时, 是中间节点的index. 当节点数量为偶数时, 是中间两个节点中靠前面的那个节点的index
        return isOdd ? midIndex : (midIndex - 1);
    }

    /**
     * 对单链表从中间节点开始进行反转
     * @param head 头节点
     * @param formerMidIndex 中间节点(对于偶数节点的链表, 指的是中间靠前的那个节点)
     * @return 经过反转后的链表
     */
    static ListNode reverseLinkedList(ListNode head, int formerMidIndex) {
        if (head == null) return head;

        int index = -1;
        ListNode curNode = head;
        ListNode nextNode = head;
        ListNode nextnextNode = null;

        ListNode tempCurNode = null;
        ListNode tempNextNode = null;
        while (curNode != null) {
            index ++;
            if (index < formerMidIndex) {
                curNode = curNode.next;
            } else {
                // 仅第一次才会执行该逻辑
                if (nextNode == head) {
                    nextNode = curNode.next;
                }
                // 已到达链表结尾了
                if (nextNode == null) {
                    return head;
                }
                // 用临时变量记录本轮迭代要用到的节点
                tempCurNode = curNode;
                tempNextNode = nextNode;
                // 先移动好下一轮迭代要用的节点
                nextnextNode = nextNode.next;
                curNode = nextNode;
                nextNode = nextnextNode;
                // 利用先前记录的临时变量进行反转
                tempNextNode.next = tempCurNode;
            }
        }
        return head;
    }

    /**
     * 获取一个链表的节点数量
     * @param head
     * @return
     */
    static int getNodesCount(ListNode head) {
        int count = 0;
        ListNode curNode = head;
        while (curNode != null) {
            count ++;
            tailNode = curNode;
            curNode = curNode.next;
        }
        return count;
    }
}
