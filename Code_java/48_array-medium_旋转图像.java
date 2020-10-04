/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
// (i,j)->(j,n-i)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = tmp;
            }
        }
        for (int i = 0; i < n/2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n-i-1];
            matrix[n-i-1] = tmp;
        }
        
    }
}
// @lc code=end

