/*
 * @lc app=leetcode.cn id=53 lang=cpp
 *
 * [53] 最大子序和
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int length = nums.size();
        if(length==0) return 0;
        vector<int> dp(length,0);
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++)
        {
            dp[i] = (dp[i-1]>0)?(dp[i-1]+nums[i]):nums[i];
            max = (max>dp[i])?max:dp[i];
        }
        return max;
    }
};
// TODO: 分治
// @lc code=end

