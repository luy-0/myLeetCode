import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] re = new int[len];
        for (int i = 0; i < len; i++) {
            re[i] = A[i]*A[i];
        }
        Arrays.sort(re);
        return re;
    }
}
// @lc code=end

