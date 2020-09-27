/*
 * @lc app=leetcode.cn id=198 lang=cpp
 *
 * [198] 打家劫舍
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int rob(vector<int>& nums) {
        int length = nums.size();
        if(length==0) return 0;
        if(length==1) return nums[0];

        vector<int> dp (length,0);
        dp[0] = nums[0];
        dp[1] = (nums[0]>nums[1])?nums[0]:nums[1];
        for(int i = 2;i<length;i++)
        {
            int case1 = dp[i-1];
            int case2 = dp[i-2]+nums[i];
            dp[i] = case1>case2 ? case1 : case2;
        }
        return dp[length-1];
    }
};
// @lc code=end

