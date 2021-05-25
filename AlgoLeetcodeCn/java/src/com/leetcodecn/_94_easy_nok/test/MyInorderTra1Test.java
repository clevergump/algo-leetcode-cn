package com.leetcodecn._94_easy_nok.test;

import com.leetcodecn._94_easy_nok.my.success.traversal.MyInorderTra1;
import com.leetcodecn.common.helper.BinaryTreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyInorderTra1Test {

    @Test
    void inorderTraversal() {
        // 树的高度是1
        Assertions.assertArrayEquals(new Object[]{1}, getTraversalValuesArr(1, null, null));
        // 树的高度是2
        Assertions.assertArrayEquals(new Object[]{1, 3}, getTraversalValuesArr(1, null, 3));
        Assertions.assertArrayEquals(new Object[]{2, 1}, getTraversalValuesArr(1, 2, null));
        Assertions.assertArrayEquals(new Object[]{2, 1, 3}, getTraversalValuesArr(1, 2, 3));
        // 树的高度是3
        Assertions.assertArrayEquals(new Object[]{4, 2, 5, 1}, getTraversalValuesArr(1, 2, null, 4, 5));
        Assertions.assertArrayEquals(new Object[]{4, 2, 5, 1, 3}, getTraversalValuesArr(1, 2, 3, 4, 5, null, null));
        Assertions.assertArrayEquals(new Object[]{2, 5, 1, 3}, getTraversalValuesArr(1, 2, 3, null, 5, null, null));
        Assertions.assertArrayEquals(new Object[]{4, 2, 1, 3}, getTraversalValuesArr(1, 2, 3, 4, null, null, null));
        Assertions.assertArrayEquals(new Object[]{4, 2, 5, 1, 6, 3, 7}, getTraversalValuesArr(1, 2, 3, 4, 5, 6, 7));
        Assertions.assertArrayEquals(new Object[]{2, 1, 6, 3, 7}, getTraversalValuesArr(1, 2, 3, null, null, 6, 7));
        Assertions.assertArrayEquals(new Object[]{2, 1, 6, 3}, getTraversalValuesArr(1, 2, 3, null, null, 6, null));
    }

    private Object[] getTraversalValuesArr(Integer... nodeValuesByLayer) {
        return MyInorderTra1.inorderTraversal(BinaryTreeFactory.createBinaryTree(nodeValuesByLayer)).toArray();
    }
}