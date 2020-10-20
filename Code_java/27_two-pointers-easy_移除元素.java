/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast=0, slow=0;
        for(;fast<nums.length;fast++){
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;

    }
}
// @lc code=end

