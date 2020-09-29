/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心索引
 */

// @lc code=start
/* 先计算总和,再计算前缀和 */
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int sum_left = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum_left*2 + nums[i] == sum){
                return i;
            }
            sum_left += nums[i];
        }
        return -1;
    }
}
// @lc code=end

