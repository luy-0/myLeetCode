/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftCurrMaxVol = height[left];
        int rightCurrMaxVol = height[right];
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftCurrMaxVol = Math.max(leftCurrMaxVol, height[left]);
                ans += leftCurrMaxVol - height[left++];
            }else{
                rightCurrMaxVol = Math.max(rightCurrMaxVol, height[right]);
                ans += rightCurrMaxVol-height[right--];
            }
        }
        return ans;
    }
}
// @lc code=end
