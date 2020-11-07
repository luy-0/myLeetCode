/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int left = 0;
        int right = A.length - 1;
        while (A[left] < A[left + 1]) {
            left++;
            if (left == A.length - 1) {
                return false;
            }
        }
        while (A[right] < A[right - 1]) {
            right--;
            if (right == 0) {
                return false;
            }
        }
        return (left == right) ? true : false;
    }
}
// @lc code=end
