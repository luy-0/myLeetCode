/*
 * @lc app=leetcode.cn id=344 lang=golang
 *
 * [344] 反转字符串
 */

// @lc code=start
func reverseString(s []byte) {
	for left := 0; left < len(s)/2; left++ {
		s[left], s[len(s)-left-1] = s[len(s)-left-1], s[left]
	}
}

// @lc code=end

