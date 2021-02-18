/*
 * @lc app=leetcode.cn id=122 lang=golang
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
func maxProfit(prices []int) int {
	res := 0
	for i, v := range prices {
		if i != 0 && v > prices[i-1] {
			res += v - prices[i-1]
		}
	}
	return res
}

// @lc code=end

