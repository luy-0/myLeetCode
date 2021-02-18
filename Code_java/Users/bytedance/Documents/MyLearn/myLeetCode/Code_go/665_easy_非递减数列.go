/*
 * @lc app=leetcode.cn id=665 lang=golang
 *
 * [665] 非递减数列
 */

// @lc code=start
func checkPossibility(nums []int) bool {
	if len(nums) < 2 {
		return true
	}
	flag := true
	if nums[0] > nums[1] {
		flag = false
	}
	for i := 1; i < len(nums)-1; i++ {
		if nums[i] > nums[i+1] {
			if flag {
				if nums[i-1] <= nums[i+1] {
					nums[i] = nums[i+1]
				} else {
					nums[i+1] = nums[i]
				}
				flag = false
			} else {
				return false
			}
		}
	}
	return true
}

// @lc code=end

