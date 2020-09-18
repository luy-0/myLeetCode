/*
 * @lc app=leetcode.cn id=101 lang=cpp
 *
 * [101] 对称二叉树
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
//      TreeNode *left;
//      TreeNode *right;
//      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
// };

/* 解法1:递归DFS */
/* class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root==nullptr)
            return true;
        return (isMirror(root->left,root->right));
        
    }
    bool isMirror(TreeNode* t1, TreeNode*t2){
        if(t1==nullptr && t2==nullptr)
            return true;
        if(t1==nullptr || t2==nullptr)
            return false;
        return (t1->val==t2->val
            && isMirror(t1->left,t2->right)
            && isMirror(t1->right,t2->left));
    }
}; */

/* 解法2:迭代BFS */
// #include <queue>
// using namespace std;
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        q.push(root);

        while (!q.empty())
        {
            TreeNode* t1 = q.front();q.pop();
            TreeNode* t2 = q.front();q.pop();
            if(t1 == nullptr && t2 == nullptr)
                continue;
            if(t1 == nullptr || t2 == nullptr
                || t1->val != t2->val)
                return false;
            q.push(t1->right);
            q.push(t2->left);
            q.push(t2->right);
            q.push(t1->left);
        }
        return true;        
    }
};
// @lc code=end

