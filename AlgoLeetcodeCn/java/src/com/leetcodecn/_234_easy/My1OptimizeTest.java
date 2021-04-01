package com.leetcodecn._234_easy;

import com.leetcodecn._234_easy.helper.SinglyLinkedListFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class My1OptimizeTest {

    @Test
    void isPalindrome() {
        Assertions.assertFalse(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(null)));
        Assertions.assertTrue(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1)));
        Assertions.assertFalse(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,2)));
        Assertions.assertTrue(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1)));
        Assertions.assertFalse(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1,2)));
        Assertions.assertFalse(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1, 2, 3)));
        Assertions.assertTrue(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,2,1)));
        Assertions.assertFalse(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1,2,3)));
        Assertions.assertTrue(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,2,2,1)));
        Assertions.assertTrue(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,2,3,2,1)));
        Assertions.assertTrue(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1,3,1,1)));
        Assertions.assertFalse(new My1Optimize().isPalindrome(SinglyLinkedListFactory.createSinglyLinkedList(1,1,3,2,1)));
    }
}