/*
 * @lc app=leetcode.cn id=643 lang=golang
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
func findMaxAverage(nums []int, k int) float64 {
	return solution1(nums, k)
}

func solution1(nums []int, k int) float64 {
	var sum int
	for i := 0; i < k; i++ {
		sum += nums[i]
	}
	maxSum := sum
	for j := k; j < len(nums); j++ {
		sum += nums[j] - nums[j-k]
		if maxSum < sum {
			maxSum = sum
		}
	}
	return float64(maxSum) / float64(k)
}

// @lc code=end

