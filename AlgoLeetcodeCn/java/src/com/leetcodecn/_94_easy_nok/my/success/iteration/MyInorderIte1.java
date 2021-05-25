package com.leetcodecn._94_easy_nok.my.success.iteration;

import com.leetcodecn.common.helper.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 迭代解法
 * 1 ms   36.5 MB
 */
public class MyInorderIte1 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()){
            TreeNode curNode = null;
            try {
                curNode = stack.pop();
                if (curNode == null){
                    continue;
                }

                if (isPureValue(curNode)){
                    result.add(curNode.val);
                } else {
                    stack.push(curNode.right);
                    stack.push(new TreeNode(curNode.val));
                    stack.push(curNode.left);
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static boolean isPureValue(TreeNode curNode) {
        return curNode != null && curNode.left == null && curNode.right == null;
    }
}
