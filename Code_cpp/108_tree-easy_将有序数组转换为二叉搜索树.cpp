/*
 * @lc app=leetcode.cn id=108 lang=cpp
 *
 * [108] 将有序数组转换为二叉搜索树
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
#include <vector>
using namespace std;
class Solution {
public:
    TreeNode* helper(vector<int>& nums,int left,int right){
        if(left>right)
            return nullptr;
        int mid = (left+right)/2;
        TreeNode* reTN = new TreeNode(nums[mid]);
        reTN->left = helper(nums,left,mid-1);
        reTN->right = helper(nums,mid+1,right);
        return reTN;
    }

    TreeNode* sortedArrayToBST(vector<int>& nums) {
        int left = 0;
        int right = nums.size()-1;
        return helper(nums,left,right);
    }
};
// @lc code=end

