/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = minPrice < prices[i] ? minPrice : prices[i];
            maxProfit = maxProfit > (prices[i] - minPrice) ? maxProfit : (prices[i] - minPrice);
        }
        return maxProfit;
    }
}
// @lc code=end
