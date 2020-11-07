/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int M = m + n - 1;
        m--;
        n--;
        while (m != -1 && n != -1) {
            if (nums1[m] < nums2[n]) {
                nums1[M--] = nums2[n--];
            } else {
                nums1[M--] = nums1[m--];
            }
        }
        if (m == -1) {
            for (int i = 0; i <= n; i++) {
                nums1[i] = nums2[i];
            }
        } else {
            for (int i = 0; i <= m; i++) {
                nums1[i] = nums1[i];
            }
        }
    }
}
// @lc code=end
