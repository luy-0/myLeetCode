/*
 * @lc app=leetcode.cn id=102 lang=cpp
 *
 * [102] 二叉树的层序遍历
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
/* 解法1: BFS->层次遍历 */
#include <vector>
#include <queue>
using namespace std;
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> reV;
        vector<int> level;
        queue<TreeNode*> q;
        TreeNode dummy = TreeNode(INT16_MIN);
        if(root==nullptr)
            return reV;
        q.push(root);
        q.push(&dummy);
        
        while (!q.empty())
        {
            TreeNode* current = q.front();q.pop();
            if(current!=&dummy)
            {
                level.push_back(current->val);
                if(current->left!=nullptr)
                    q.push(current->left);
                if(current->right!=nullptr)
                    q.push(current->right);
            }else
            {
                reV.push_back(level);
                level.clear();
                if(!q.empty())
                    q.push(&dummy);
            }
        }
        return reV;
    }
};
// @lc code=end

