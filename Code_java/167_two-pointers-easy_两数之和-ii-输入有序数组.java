/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
/* 解法1 暴力 */
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         for (int i = 0; i < numbers.length; i++) {
//             for (int j = numbers.length-1; j >i; j--) {
//                 if (j == numbers.length-1 && (numbers[i]+numbers[j] < target)) {
//                     continue;
//                 }
//                 if (numbers[i]+numbers[j] == target) {
//                     return new int[]{i+1,j+1};
//                 }
//             }
//         }
//         return new int[2];
//     }
// }

/* 解法2 双指针 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p = 0;
        int q = numbers.length-1;
        while (numbers[p] + numbers[q] != target) {
            if(numbers[p] + numbers[q] > target){
                q--;
            }
            if(numbers[p] + numbers[q] < target){
                p++;
            }
        }
        return new int[]{p+1, q+1};
    }
}
// @lc code=end

