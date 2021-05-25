package com.leetcodecn._226_easy.my.success;

import com.leetcodecn.common.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 辅助队列法-迭代, 层序遍历 BFS
 * 0ms 35.6MB
 */
public class MyInvert_BFS1 {
    public TreeNode invertTree(TreeNode root) {
        // 双端队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tempLeft = null;
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (curNode == null) {
                continue;
            }
            tempLeft = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tempLeft;
            queue.add(curNode.left);
            queue.add(curNode.right);
        }
        return root;
    }
}