/*
 * @lc app=leetcode.cn id=98 lang=cpp
 *
 * [98] 验证二叉搜索树
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
// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
// };
class Solution {
public:
    bool helper(TreeNode* root, long long highest, long long lowest){
        if(root == nullptr)
            return true;
        if(root->val<=lowest || root->val>=highest)
            return false;
        
        
        return
            helper(root->right,highest,root->val)&&
            helper(root->left,root->val,lowest);

    }
    bool isValidBST(TreeNode* root) {
        return helper(root, LONG_MAX,LONG_MIN);
    }
};
// @lc code=end

