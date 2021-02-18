/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	// return solution1(nums, target)
	return solution2(nums, target)

}

func solution1(nums []int, target int) []int {
	for i, v := range nums {
		for j := i + 1; j < len(nums); j++ {
			if v+nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return nil
}

func solution2(nums []int, target int) []int {
	hashmap := map[int]int{}
	for i, v := range nums {
		if p, ok := hashmap[target-v]; ok {
			return []int{i, p}
		}
		hashmap[v] = i
	}
	return nil
}

// @lc code=end

