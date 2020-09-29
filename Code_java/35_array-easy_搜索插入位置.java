/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
/* 解法1 暴力 */
// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i]>=target) {
//                 return i;
//             }
//         }
//         return nums.length;
//     }
// }
/* 解法2: 二分 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        int re = nums.length;
        while (left<=right) {
            int mid = ((right-left)>>1) + left;
            // 注意: 位运算符的优先级低于+-,需要加括号否则TLE
            if(target<=nums[mid]){
                re = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return re;
    }
}
// @lc code=end

