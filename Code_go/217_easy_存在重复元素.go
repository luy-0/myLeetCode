/*
 * @lc app=leetcode.cn id=217 lang=golang
 *
 * [217] 存在重复元素
 */

// @lc code=start
func containsDuplicate(nums []int) bool {

}
func solution1(nums []int) bool {
	hashMap := map[int]int{}
	for _, v := range nums {
		if _, ok := hashMap[v]; ok {
			return true
		} else {
			hashMap[v] = 0
		}
	}
	return false
}

func solution2(nums []int) bool {
	sort.Int(nums)

}

// @lc code=end

