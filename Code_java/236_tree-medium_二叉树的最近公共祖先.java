import javax.management.relation.Relation;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode(int x) {
// val = x;
// }
// }

class Solution {
    TreeNode ans = null;

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        if (ans != null) {
            return false;
        }
        boolean retLeft = helper(node.left, p, q);
        boolean retRight = helper(node.right, p, q);
        boolean isVal = (node.val == p.val | node.val == q.val);
        boolean ret = retLeft | retRight | isVal;
        if (ret & !(retLeft ^ retRight ^ isVal)) {
            ans = node;
            return false;
        }
        return ret;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }
}
// @lc code=end
