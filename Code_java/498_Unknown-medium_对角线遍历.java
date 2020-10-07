/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length -1;
        int n = matrix[0].length -1;
        int[] re = new int[(m+1)*(n+1)];
        int x=0, y=0;
        for (int i = 0; i < re.length; i++) {
            re[i] = matrix[x][y];
            // boolean isRightUp = (x+y)%2 == 0 ? true:false;
            if ((x+y)%2 == 0) {
                if(y == n){
                    x++;
                }
                else if(x == 0){
                    y++;
                }
                else{
                    x--;
                    y++;
                }
            }
            else{
                if(x == m){
                    y++;
                }
                else if(y == 0){
                    x++;
                }
                else{
                    x++;
                    y--;
                }
            }
        }
        return re;
    }
}
// @lc code=end

