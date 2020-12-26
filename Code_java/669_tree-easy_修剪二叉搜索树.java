/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        /*
        考虑到root的值与low,high相比有三种可能性
        */
        if(root==null){
            return null;
        }
        if(root.val<low){
            // 说明符合的子树在右边
            return trimBST(root.right, low, high);
        }
        if(root.val>high){
            // 说明符合的子树在左边
            return trimBST(root.left, low, high);
        }
        // 说明左右子树中都可能有符合的子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

}
// @lc code=end

