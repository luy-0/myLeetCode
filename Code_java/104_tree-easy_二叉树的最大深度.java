/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
 * 自底向上
 * 
 */

// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//     }
// }

/**
 * 自顶向下
 * 
 */
class Solution {
    private int ans;

    private void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        ans = Math.max(ans, depth);
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        helper(root, 1);
        return ans;
    }
}
// @lc code=end
