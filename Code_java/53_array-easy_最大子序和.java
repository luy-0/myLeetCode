/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int dp = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(dp<0){
                max = Math.max(nums[i],max);
                dp = nums[i];
            }else{
                dp += nums[i];
                max = Math.max(dp,max);
            }
        }
        return max;
    }
}
// @lc code=end

