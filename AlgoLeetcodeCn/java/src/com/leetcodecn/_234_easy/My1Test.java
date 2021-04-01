package com.leetcodecn._234_easy;

import com.leetcodecn._234_easy.helper.ListNode;
import com.leetcodecn._234_easy.helper.SinglyLinkedListFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class My1Test {

    @Test
    void isPalindrome() {
        Assertions.assertFalse(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(null)));
        Assertions.assertTrue(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1)));
        Assertions.assertFalse(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,2)));
        Assertions.assertTrue(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1)));
        Assertions.assertFalse(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1,2)));
        Assertions.assertTrue(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,2,1)));
        Assertions.assertFalse(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1,2,3)));
        Assertions.assertTrue(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,2,2,1)));
        Assertions.assertTrue(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,2,3,2,1)));
        Assertions.assertTrue(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1,3,1,1)));
        Assertions.assertFalse(new My1().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1,3,2,1)));
    }

    @Test
    void internalTestCreateSinglyLinkedList(){
        ListNode head1 = SinglyLinkedListFactory.createSinglyLinkedList(1,2,3,4,5,6,7,8);
        print(head1.getValuesStr());
    }
    
    @Test
    void internalTestGetMidOrFormerMidIndex(){
        Assertions.assertEquals(0, My1.getMidOrFormerMidIndex(My1.getNodesCount(SinglyLinkedListFactory.createSinglyLinkedList(1))));
        Assertions.assertEquals(0, My1.getMidOrFormerMidIndex(My1.getNodesCount(SinglyLinkedListFactory.createSinglyLinkedList(1,2))));
        Assertions.assertEquals(1, My1.getMidOrFormerMidIndex(My1.getNodesCount(SinglyLinkedListFactory.createSinglyLinkedList(1,2,3))));
        Assertions.assertEquals(1, My1.getMidOrFormerMidIndex(My1.getNodesCount(SinglyLinkedListFactory.createSinglyLinkedList(1,2,3,4))));
        Assertions.assertEquals(2, My1.getMidOrFormerMidIndex(My1.getNodesCount(SinglyLinkedListFactory.createSinglyLinkedList(1,2,3,4,5))));
        Assertions.assertEquals(2, My1.getMidOrFormerMidIndex(My1.getNodesCount(SinglyLinkedListFactory.createSinglyLinkedList(1,2,3,4,5,6))));
    }

    @Test
    void internalTestReverseLinkedList(){
        ListNode list1 = SinglyLinkedListFactory.createSinglyLinkedList(1,2,3,4,5,6);
        My1.reverseLinkedList(list1, My1.getMidOrFormerMidIndex(My1.getNodesCount(list1)));
    }

    private void print(String str){
        System.out.println(str);
    }
}