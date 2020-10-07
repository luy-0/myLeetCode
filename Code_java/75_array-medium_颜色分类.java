/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
/* 解法1 两次遍历 */
/* class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }
    }
} */



/* 解法2 */
// class Solution {
//     public void sortColors(int[] nums) {
//         int p0 = 0;
//         int p1 = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) {
//                 int tmp = nums[i];
//                 nums[i] = nums[p0];
//                 nums[p0] = tmp;
//                 if (p0<p1) {
//                     tmp = nums[i];
//                     nums[i] = nums[p1];
//                     nums[p1] = tmp;
//                 } 
//                 p0++;
//                 p1++;
//             }
//             else if(nums[i] == 1) {
//                 int tmp = nums[i];
//                 nums[i] = nums[p1];
//                 nums[p1++] = tmp;
//             }
//         } 
//     }
// }

/* 解法3 双指针 */
class Solution {
    public void sortColors(int[] nums) {
        int ptr_0 = 0;
        int ptr_2 = nums.length-1;
        for (int i = 0; i < nums.length; ) {
            if (i>=ptr_0 & nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr_0];
                nums[ptr_0++] = tmp;
            }
            else if (i<ptr_2 & nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[ptr_2];
                nums[ptr_2--] = tmp;
            }
            else {
                i++;
            }
        } 
    }
}
// @lc code=end

