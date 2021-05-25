package com.leetcodecn._104_easy.my;

import com.leetcodecn.common.helper.TreeNode;

/**
 * 递归解法
 *
 * 0ms  38.1MB
 */
public class MyRecur1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}