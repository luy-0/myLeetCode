/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
/* 解法1: 双指针 */
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int fast=0, slow=0;
//         int max = 0;
//         int pre = 0;
//         for(;fast<nums.length;fast++){
//             if(nums[fast] == 0 && pre == 1){
//                 int curr_count = fast - slow;
//                 max = max > curr_count?max:curr_count;
//                 pre = 0;
//             }
//             if(nums[fast]==1 && pre == 0){
//                 slow = fast;
//                 pre = 1;  
//             }
//         }
//         if(nums[nums.length-1] == 1){
//             int curr_count = fast - slow;
//             max = max > curr_count?max:curr_count;
//         }
//         return max;
//     }
// }

/* 解法2:一次遍历 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i : nums) {
            if(i==1){
                count++;
            }
            else{
                max = max>count?max:count;
                count = 0;
            }
        }
        if(nums[nums.length-1] == 1){
            max = max>count?max:count;
        }
        return max;
    }
}
// @lc code=end

