/*
 * @lc app=leetcode.cn id=122 lang=cpp
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
#include <vector>
using namespace std;
/* 解法1 暴力(失败)
思路不严谨,无参考价值 */
/*解法1-Code
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int DayLength = prices.size();
        int income=0;
        for(int beginDay=0;beginDay<DayLength;beginDay++){
            
            for(int endDay = beginDay;endDay<DayLength;endDay++)
                income = (prices[endDay]-prices[beginDay]>income)?(prices[endDay]-prices[beginDay]):income;
        }
        return income;
    }
};
*/

/* 解法2 贪心 t_94 s_100
只需要今天比昨天高就买卖,明天是否比今天高明天再说
 */
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int length = prices.size();
        if (length<=1)
            return 0;
        int income = 0;
        for(int i = 1;i<length;i++)
            income += (prices[i]-prices[i-1]>0)?prices[i]-prices[i-1]:0;
        
        return income;
    }
};
// @lc code=end

