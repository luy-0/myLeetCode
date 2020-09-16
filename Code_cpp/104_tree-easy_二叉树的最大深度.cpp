/*
 * @lc app=leetcode.cn id=104 lang=cpp
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
/* struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
}; */
/* 解法1:递归 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(!root)
            return 0;
        int l_depth = maxDepth(root->left);
        int r_depth = maxDepth(root->right);
        int cur_depth = (l_depth>r_depth) ? l_depth+1:r_depth+1;
        return cur_depth;

    }
};
// @lc code=end

