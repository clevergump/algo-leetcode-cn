package com.leetcodecn._234_easy;

import com.leetcodecn._234_easy.helper.ListNode;

/**
 * 链表反转法, 对 {@link My1}的思路更清晰
 *
 * 1. 将一个链表从中间节点拆分为两个节点数量相等的链表 (拆分过程中, 如果原链表节点数为奇数, 则要在中间节点后面插入一个克隆的中间节点使节点总数为偶数,
 * 然后再做拆分)
 * 2. 然后将拆分后的前边的链表进行反转使先前的中间节点变为该链表的头节点
 * 3. 最后逐一比较两个链表上的节点.
 *
 *
 * 7 ms, 在所有 Java 提交中击败了26.45%的用户
 * 48.5 MB, 在所有 Java 提交中击败了24.87%的用户
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
public class My1Optimize {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        HeadsContainer headsOfEachList = calcHeadNodesOfEachHalfList(head);
        partiallyReverseList(head, headsOfEachList.head1);
        return compareNodesOfTwoList(headsOfEachList);
    }

    /**
     * 将链表平分为两个子链表, 并计算各个子链表未来的头节点
     */
    private HeadsContainer calcHeadNodesOfEachHalfList(ListNode headNode) {
        ListNode fast = headNode;
        ListNode slow = headNode;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表中节点数量是否为奇数
        boolean isNodeCountOdd = (fast.next == null);
        ListNode head1;
        ListNode head2;
        if (isNodeCountOdd){
            // 在slow节点后面额外插入一个和slow val 完全相同的节点, 以使节点数变为偶数, 从而让两个队列不共用起点
            // (因为要求两个对象的头节点的 next指针各自指向自己的方向, 所以两个队列不能共用头节点, 所以需要克隆一个slow节点插入到紧邻slow的后面)
            ListNode temp = slow.next;
            head2 = new ListNode(slow.val, temp);
            slow.next = head2;
            head1 = slow;
        } else {
            head1 = slow;
            head2 = slow.next;
        }
        return new HeadsContainer(head1, head2);
    }

    /**
     * 对链表中从头节点 headNode 到节点 endReverseNode 的这部分节点进行反转, 即: 对链表进行部分反转
     *
     * @param headNode 链表的头节点
     * @param endReverseNode 链表中结束反转的节点(不一定是链表的尾节点)
     */
    private void partiallyReverseList(ListNode headNode, ListNode endReverseNode) {
        if (headNode == null) return;
        ListNode currNode = headNode;
        ListNode nextNode = headNode.next;
        ListNode tempNextNode = nextNode;
        while (currNode != endReverseNode){
            // 因为已经有 tempNextNode 作为nextNode的代理, 如果其他节点要寻找 nextNode 当前的位置,
            // 完全可以转为寻找其代理 tempNextNode 的位置, 所以 nextNode 就可以先移动到新位置
            nextNode = nextNode.next;
            // 反转
            tempNextNode.next = currNode;
            // 向后移动 currNode 和 tempNextNode 节点
            currNode = tempNextNode;
            tempNextNode = nextNode;
        }
    }

    /**
     * 逐一对比两个链表各自节点的数值是否相等
     * @param headsContainer 前半部分的链表的头节点
     * @return 两个链表各自对应下标的数值是否都相等
     */
    private boolean compareNodesOfTwoList(HeadsContainer headsContainer) {
        ListNode head1 = headsContainer.head1;
        ListNode head2 = headsContainer.head2;

        while (head1 != null && head2 != null) {
            if(head1.val != head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }


    private class HeadsContainer {
        public ListNode head1;
        public ListNode head2;

        public HeadsContainer(ListNode head1, ListNode head2) {
            this.head1 = head1;
            this.head2 = head2;
        }
    }
}
