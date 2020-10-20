/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
/* 解法1 暴力  */
/* class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total<s) {
            return 0;
        }

        int minLength = nums.length;
        int fast, slow = 0;
        for(;slow<nums.length;slow++){
            if(nums[slow]>=s){
                return 1;
            }
            fast = slow + 1;
            int sum = nums[slow];
            while(sum<s && fast!=nums.length && fast-slow<=minLength){
                sum += nums[fast++];
            }
            if(sum>=s){
                minLength = Math.min(minLength, fast-slow);
            }
            
        }
        return minLength;
    }
} */

/* 解法2 双指针(滑动窗口) */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int fast = 0;
        int slow = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(fast != nums.length){
            sum += nums[fast];
            while(sum>=s){
                min = Math.min(min, fast-slow+1);
                sum -= nums[slow];
                slow++;
            }
            fast++;
        }
        return min == Integer.MAX_VALUE ? 0:min;
    }
}
// @lc code=end

