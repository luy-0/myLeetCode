/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {

    public boolean helper(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        if(root.val>=max || root.val<=min){
            return false;
        }

        return 
            helper(root.left, Math.min(root.val,max), min) 
            && helper(root.right, max, Math.max(root.val,min));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return 
            helper(root.left, root.val, Long.MIN_VALUE) 
            && helper(root.right, Long.MAX_VALUE, root.val);
    }
}
// @lc code=end
