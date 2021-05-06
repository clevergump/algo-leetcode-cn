package com.leetcodecn.common.helper;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFactory {
    /**
     * key: index of the {@link TreeNode} in the node values array
     * value: {@link TreeNode} object
     */
    private static Map<Integer, TreeNode> nodeCache = new HashMap<>();

    /**
     * 创建二叉树
     * @param nodeValuesByLayer 二叉树按层遍历（BFS）时各节点的val值.
     *                          例1： 有如下结构的二叉树, 则该参数的数值将是 [1,2,3,4,5,6,7]
     *                           1
     *                         /  \
     *                        2    3
     *                      /  \  / \
     *                     4   5 6   7
     *
     *                          例2： 有如下结构的二叉树, 则该参数的数值将是 [1,2,3,4, null,6,7]
     *                           1
     *                         /  \
     *                        2    3
     *                      /     / \
     *                     4     6   7
     *
     * @return 创建的二叉树的根节点
     */
    public static TreeNode createBinaryTree(Integer... nodeValuesByLayer) {
        if (nodeValuesByLayer == null || nodeValuesByLayer.length == 0) return null;
        TreeNode root = createTreeNode(nodeValuesByLayer[0]);
        nodeCache.put(0, root);
        for (int i = 1; i <= nodeValuesByLayer.length - 2; i += 2) {
            int parentIndex = (i + 1) / 2 - 1;
            TreeNode parent = nodeCache.get(parentIndex);
            setChildAndCache(parent, i, i+1, nodeValuesByLayer[i], nodeValuesByLayer[i+1]);
        }
        return root;
    }

    private static void setChildAndCache(TreeNode parent, int leftChildIndex, int rightChildIndex, Integer leftChildValue,
                                         Integer rightChildValue) {
        if (parent == null) return;
        TreeNode leftChild = createTreeNode(leftChildValue);
        TreeNode rightChild = createTreeNode(rightChildValue);
        nodeCache.put(leftChildIndex, leftChild);
        nodeCache.put(rightChildIndex, rightChild);
        parent.left = leftChild;
        parent.right = rightChild;
    }

    private static TreeNode createTreeNode(Integer nodeValue) {
        return (nodeValue == null) ? null : new TreeNode(nodeValue);
    }
}
