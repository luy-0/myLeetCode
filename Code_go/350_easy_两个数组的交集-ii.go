/*
 * @lc app=leetcode.cn id=350 lang=golang
 *
 * [350] 两个数组的交集 II
 */
// @lc code=start
func intersect(nums1 []int, nums2 []int) []int {
	sort.Ints(nums1)
	sort.Ints(nums2)
	res := make([]int, 0)
	for i, j := 0, 0; ; {
		if i == len(nums1) || j == len(nums2) {
			break
		}
		if nums1[i] == nums2[j] {
			res = append(res, nums1[i])
			i++
			j++
		} else {
			if nums1[i] > nums2[j] {
				j++
			} else {
				i++
			}
		}
	}
	return res
}

// @lc code=end

