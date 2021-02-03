package com.leetcodecn._21_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.leetcodecn._21_easy._21IterationWithoutGuard.*;

class _21IterationWithoutGuardTest {

    ListNode l1;
    ListNode l2;
    ListNode l3;
    ListNode l4;

    @BeforeEach
    void init() {
        ListNode n1 = new ListNode(1);
        ListNode _n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode _n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode _n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode _n4 = new ListNode(4);

        l1 = _n2;
        _n2.next = n2;
        n2.next = n4;
//        setNodes(l1, new ListNode[]{n1, n2, n4});

        l2 = _n1;
        _n1.next = _n3;
        _n3.next = _n4;

        printNodesValues(l1, "l1 values=", 3);

        printNodesValues(l2, "l2 values=", 3);
    }

    private void printNodesValues(ListNode startingNode, String tipsBeforePrint, int nodesCnt) {
        ArrayList<Integer> nodesValues = new ArrayList<>(nodesCnt);
        for (ListNode ptr = startingNode; ptr != null; ptr = ptr.next) {
            nodesValues.add(ptr.val);
        }
        System.out.println(tipsBeforePrint);
        for (Integer curNodeValue : nodesValues) {
            System.out.print(curNodeValue);
            System.out.print(' ');
        }
        System.out.println();
    }

    private List<Integer> getNodesValues(ListNode startingNode, int nodesCnt) {
        ArrayList<Integer> nodesValues = new ArrayList<>(nodesCnt);
        for (ListNode ptr = startingNode; ptr != null; ptr = ptr.next) {
            nodesValues.add(ptr.val);
        }
        return nodesValues;
    }

    private void setNodes(ListNode firstNode, ListNode[] nodes) {
        if (nodes == null || nodes.length == 0) return;
        for (int i = 0; i <= nodes.length - 2; i++) {
            nodes[i].next = nodes[i + 1];
        }
        firstNode = nodes[0];
    }

    @Test
    void mergeTwoLists() {
        ListNode node1 = new _21IterationWithoutGuard().mergeTwoLists(null, null);
        Assertions.assertEquals(null, node1);

        ListNode _node1 = new _21IterationWithoutGuard().mergeTwoLists(null, l2);
        Assertions.assertEquals(l2, _node1);

        ListNode __node1 = new _21IterationWithoutGuard().mergeTwoLists(null, l1);
        Assertions.assertEquals(l1, __node1);




        ListNode node2 = new _21IterationWithoutGuard().mergeTwoLists(l1, l2);
        List<Integer> nodesValues = getNodesValues(node2, 6);
        int[] expected = {1, 2, 2, 3, 4, 4};
        Assertions.assertEquals(expected.length, nodesValues.size());
        for (int i=0; i<nodesValues.size(); i++){
            Assertions.assertEquals(expected[i], nodesValues.get(i).intValue());
        }
    }
}