package com.leetcodecn._94_easy_nok.my.fail;

import com.leetcodecn._94_easy_nok.official.OfficialInorderTraversal2;
import com.leetcodecn.common.helper.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 迭代解法。 运行fail，test不通过，报错。
 *
 * 需反复研究官方的迭代解法 {@link OfficialInorderTraversal2}
 */
public class InorderTraversal2_Fail {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;

        List<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        /** 当前正在遍历的节点 */
        TreeNode current = root;
        stack.push(current);
        boolean shouldPush = true;


        /** 只要栈不为空， 或者栈虽然空了但是当前正在遍历的节点仍有（左或右）子节点， 则循环就会继续运行下去 */
        while (!stack.isEmpty() || containsChild(current)) {
            if (shouldPush) {
                pushAllLeftLIFO(stack, current);
            }
            current = stack.pop();
            ret.add(current.val);
            if (current.right != null) {
                current = current.right;
                stack.push(current);
                shouldPush = true;
            } else {
                shouldPush = false;
            }
        }

        return ret;
    }

    private static boolean containsChild(TreeNode node) {
        if (node == null) return false;
        return node.left != null || node.right != null;
    }

    /**
     * 将给定的根节点的所有后代左子节点按后进先出的顺序放入给定的栈中
     * @param stack 给定的栈
     * @param root 给定的根节点
     */
    private static void pushAllLeftLIFO(LinkedList<TreeNode> stack, TreeNode root) {
        if (root == null) return;
        TreeNode currentLeft = root.left;
        while (currentLeft != null) {
            stack.push(currentLeft);
            currentLeft = currentLeft.left;
        }
    }
}