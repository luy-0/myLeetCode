/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 */

// @lc code=start
/* 解法1:滚动数组 */
// class Solution {
// public:
//     int climbStairs(int n) {
//         int p=0,q=0,r=1;
//         for (int i = 0; i < n; i++)
//         {
//             p = q;
//             q = r;
//             r = p+q;
//         }
//         return r;
//     }
// };

/* 解法2:动态规划 */
#include <vector>
using namespace std;
class Solution {
public:
    int climbStairs(int n) {
        if(n==1)return 1;
        vector<int> dp(n+1,0);
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i-1]+dp[i-2];
        return dp[n];
    }
};
// @lc code=end

