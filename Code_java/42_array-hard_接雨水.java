import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (height == null || n < 3) {
            return 0;
        }
        int ans = 0;
        int[] leftMaxVol = new int[n];
        int[] rightMaxVol = new int[n];

        leftMaxVol[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxVol[i] = Math.max(leftMaxVol[i-1], height[i]);
        }

        rightMaxVol[n-1] = height[n-1];
        for (int i = n-2; i >=0; i--) {
            rightMaxVol[i] = Math.max(rightMaxVol[i+1], height[i]);
        }

        // 用于打印的两个数组,以便纠错
        /* for (int i = 0; i < leftMaxVol.length; i++) {
            System.out.printf("%d,", leftMaxVol[i]);
        }
        System.out.println();

        for (int i = 0; i < rightMaxVol.length; i++) {
            System.out.printf("%d,", rightMaxVol[i]);
        }
        System.out.println(); */

        

        for (int i = 1; i < height.length-1; i++) {
            int leftHeight = Math.min(leftMaxVol[i-1], rightMaxVol[i-1]);
            int rightHeight = Math.min(leftMaxVol[i+1], rightMaxVol[i+1]);

            if (leftHeight<=height[i] || rightHeight<= height[i]) {
                continue;
            }
            ans += Math.min(leftHeight, rightHeight) - height[i];

        }
        return ans;
    }
}
// @lc code=end
