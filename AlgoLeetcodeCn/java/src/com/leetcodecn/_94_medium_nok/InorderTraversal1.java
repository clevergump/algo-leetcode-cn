package com.leetcodecn._94_medium_nok;

import com.leetcodecn.common.helper.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 递归解法
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了44.28%的用户
 *
 */
public class InorderTraversal1 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        inorderTraversalAndSetValue(ret, root);
        return ret;
    }

    private static void inorderTraversalAndSetValue(List<Integer> values, TreeNode root) {
        if (root == null) return;
        inorderTraversalAndSetValue(values, root.left);
        values.add(root.val);
        inorderTraversalAndSetValue(values, root.right);
    }
}