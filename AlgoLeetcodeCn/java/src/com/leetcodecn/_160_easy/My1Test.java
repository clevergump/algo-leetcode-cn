package com.leetcodecn._160_easy;

import com.leetcodecn.common.helper.ListNode;
import com.leetcodecn.common.helper.SinglyLinkedListFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class My1Test {

    @Test
    void getIntersectionNode() {
        ListNode head1 = SinglyLinkedListFactory.createSinglyLinkedList(1, 2);
        ListNode head2 = SinglyLinkedListFactory.createSinglyLinkedList(1, 2, 3, 4);
        Assertions.assertSame(null, new My1().getIntersectionNode(head1, head2));



        ListNode commonHead1 = SinglyLinkedListFactory.createSinglyLinkedList(10,11,12);
        head1.getTailNode().next = commonHead1;
        head2.getTailNode().next = commonHead1;
        Assertions.assertSame(commonHead1, new My1().getIntersectionNode(head1, head2));
    }
}