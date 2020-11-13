/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] ans = new int[A.length];
        int i = 0;
        int j = 1;
        for (int k = 0; k < A.length; k++) {
            if (A[k] % 2 == 0) {
                ans[i] = A[k];
                i+=2;
            } else {
                ans[j] = A[k];
                j+=2;
            }
        }
        return ans;
    }
}


// @lc code=end
