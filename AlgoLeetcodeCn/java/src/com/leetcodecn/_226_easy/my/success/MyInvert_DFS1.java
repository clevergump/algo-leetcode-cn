package com.leetcodecn._226_easy.my.success;

import com.leetcodecn.common.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 辅助栈法-迭代, DFS
 *  0ms 35.7MB
 */
public class MyInvert_DFS1 {
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            if (curNode == null){
                continue;
            }
            TreeNode tempLeft = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tempLeft;
            stack.push(curNode.left);
            stack.push(curNode.right);
        }
        return root;
    }
}