import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
/* 解法1: 平方+排序 */
// class Solution {
//     public int[] sortedSquares(int[] A) {
//         int len = A.length;
//         int[] re = new int[len];
//         for (int i = 0; i < len; i++) {
//             re[i] = A[i]*A[i];
//         }
//         Arrays.sort(re);
//         return re;
//     }
// }

/* 解法2: 双指针 */
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] re = new int[len];
        int p = 0;
        int q = len - 1;
        int k = q;

        while(A[p]<=0 && A[q]>0){
            if(Math.abs(A[p]) > A[q]){
                re[k--] = A[p] * A[p++];
            }
            else{
                re[k--] = A[q] * A[q--];
            }
        }
        while(p<=q && A[p]<=0){
            re[k--] = A[p] * A[p++];
        }
        while(p<=q && A[q]>0){
            re[k--] = A[q] * A[q--];
        }

        return re;
    }
}
// @lc code=end

