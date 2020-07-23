/*
 * @lc app=leetcode.cn id=122 lang=cpp
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
#include <vector>
using namespace std;
/* 解法1 dfs 超时 但值得回顾
思路见: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 */
void dfs(vector<int>& prices,int Day,int len,int status,int income,int& bestIncome)
{
    if(Day==len)
    {
        bestIncome = (bestIncome>income)?bestIncome:income;
        return;
    }

    dfs(prices,Day+1,len,status,income,bestIncome);

    if(status==0){
        dfs(prices,Day+1,len,1,income-prices[Day],bestIncome);
    }
    else
    {
        dfs(prices,Day+1,len,0,income+prices[Day],bestIncome);
    }
}

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int bestIncome = 0;
        int len = prices.size();
        if(len<2)return bestIncome;
        dfs(prices,0,len,0,0,bestIncome);
        return bestIncome;
    }
};

/* 解法2 贪心 t_94 s_100
只需要今天比昨天高就买卖,明天是否比今天高明天再说
此处略
 */
// @lc code=end

