/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
/* class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftMul = new int[n];
        int[] rightMul = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                leftMul[i] = nums[i];
            } else {
                leftMul[i] = nums[i] * leftMul[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                rightMul[i] = nums[i];
            } else {
                rightMul[i] = nums[i] * rightMul[i + 1];
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            if (i == 0) {
                ans[i] = rightMul[i + 1];
                continue;
            }
            if (i == n - 1) {
                ans[i] = leftMul[i - 1];
                continue;
            }
            ans[i] = leftMul[i-1] * rightMul[i+1];
        }
        return ans;
    }
} */

// 空间复杂度的优化
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                ans[i] = nums[i];
            } else {
                ans[i] = nums[i] * ans[i + 1];
            }
        }
        int leftMul = nums[0];
        for (int i = 0; i < ans.length; i++) {
            if (i == 0) {
                ans[i] = ans[i + 1];
                continue;
            }
            if (i == n - 1) {
                ans[i] = leftMul;
                continue;
            }
            ans[i] = leftMul * ans[i + 1];
            leftMul *= nums[i];
        }
        return ans;
    }
}

// @lc code=end
