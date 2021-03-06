package com.leetcodecn.common.helper;

/**
 * 单向链表
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 为该节点设置下一个节点
     * @param val 下一个节点的数值
     * @return 该节点的下一个节点对象
     */
    // only for unit test
    public ListNode setNextNode(int val){
        ListNode nextNode = new ListNode(val);
        this.next = nextNode;
        return nextNode;
    }

    /**
     * 将链表中各节点的数值按先后顺序拼接成字符串, 中间用逗号分隔
     * @return
     */
    // only for unit test
    public String getValuesStr(){
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode curNode = next;
        while (curNode != null) {
            sb.append(", ").append(curNode.val);
            curNode = curNode.next;
        }
        return sb.toString();
    }

    // only for unit test
    public ListNode getTailNode(){
        ListNode tail = this;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }
}
