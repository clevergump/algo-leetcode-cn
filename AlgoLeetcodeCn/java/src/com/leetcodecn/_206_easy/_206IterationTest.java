package com.leetcodecn._206_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leetcodecn._206_easy._206Iteration.*;

class _206IterationTest {

    private ListNode nullList = null;
    private ListNode l1;
    private ListNode l2;

    @BeforeEach
    void init() {
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        l2 = new ListNode(100);
    }

    @Test
    void reverseList() {
        Assertions.assertNull(new _206Iteration().reverseList(nullList));

        List<Integer> valuesArr1 = new _206Iteration().reverseList(l1).getValuesArr();
        Assertions.assertEquals(4, valuesArr1.get(0).intValue());
        Assertions.assertEquals(3, valuesArr1.get(1).intValue());
        Assertions.assertEquals(2, valuesArr1.get(2).intValue());
        Assertions.assertEquals(1, valuesArr1.get(3).intValue());

        List<Integer> valuesArr2 = new _206Iteration().reverseList(l2).getValuesArr();
        Assertions.assertEquals(100, valuesArr2.get(0).intValue());
    }
}