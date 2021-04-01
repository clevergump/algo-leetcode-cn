package com.leetcodecn._234_easy.helper;

/**
 * 单向链表
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 为该节点设置下一个节点
     * @param val 下一个节点的数值
     * @return 该节点的下一个节点对象
     */
    public ListNode setNextNode(int val){
        ListNode nextNode = new ListNode(val);
        this.next = nextNode;
        return nextNode;
    }

    /**
     * 将链表中各节点的数值按先后顺序拼接成字符串, 中间用逗号分隔
     * @return
     */
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
}
