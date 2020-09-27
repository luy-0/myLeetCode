/*
 * @lc app=leetcode.cn id=121 lang=cpp
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
#include <vector>
using namespace std;
/* 解法0: 两次暴力,TLE */
/* 解法1: 一次遍历,找出:如果今日卖出,最大收益为? */
// class Solution {
// public:
//     int maxProfit(vector<int>& prices) {
//         int maxprofit = 0;
//         int minprice = 1e9;
//         int length = prices.size();
//         for (int i = 0; i < length; i++)
//         {
//             minprice = (minprice<prices[i])?minprice:prices[i];
//             maxprofit = (maxprofit>prices[i]-minprice)?maxprofit:(prices[i]-minprice);
//         }
//         return maxprofit;
//     }
// };

/* 解法2:dp */
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int length = prices.size();
        if(length == 0) return 0;
        int minprice = prices[0];
        vector<int> dp (length,0);
        for(int i=1;i<length;i++)
        {
            minprice = (minprice<prices[i])?minprice:prices[i];
            dp[i] = (dp[i-1]>prices[i]-minprice)?dp[i-1]:(prices[i]-minprice);
        }
        return dp[length-1];
    }
};

// @lc code=end

