/*
 * @lc app=leetcode.cn id=88 lang=cpp
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/* 解法1: 倒序 */
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int index_1 = m-1;
        int index_2 = n-1;
        int curr = m+n-1;
        while (index_1>-1 && index_2>-1)
        {
            nums1[curr--] = (nums1[index_1]>nums2[index_2])?nums1[index_1--]:nums2[index_2--];
        }
        while(index_2>-1)
        {
            nums1[index_2] = nums2[index_2];
            index_2--;
        }
    }
};
// @lc code=end

