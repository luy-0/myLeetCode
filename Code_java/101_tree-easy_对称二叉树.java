import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

import sun.reflect.generics.tree.Tree;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 递归法
 */
// class Solution {
// /**
// * helper: Is two trees mirror?
// *
// * @param left
// * @param right
// * @return
// */
// private boolean helper(TreeNode left, TreeNode right) {
// if(left == null || right==null){
// if(left==null&&right==null){
// return true;
// }
// return false;
// }
// return (left.val == right.val
// && helper(left.left, right.right)
// && helper(left.right, right.left));
// }

// public boolean isSymmetric(TreeNode root) {
// if(root==null){
// return true;
// }
// return helper(root.left, root.right);
// }
// }

/**
 * 迭代法
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.remove();
            TreeNode second = queue.remove();
            if (first == null && second == null) {
                continue;
            }
            if (first == null || second == null || first.val != second.val) {
                return false;
            }

            queue.add(first.left);
            queue.add(second.right);

            queue.add(first.right);
            queue.add(second.left);
        }
        return true;
    }
}
// @lc code=end
