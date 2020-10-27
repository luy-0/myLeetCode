/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int p = nums.length - 1;
        while (p != 0) {
            if (nums[p - 1] < nums[p]) {
                break;
            }
            p--;
        }

        if (p == 0) {
            reverse(nums, 0);
            return;
        }

        int q = p - 1;
        while (p != nums.length) {
            if (nums[p] <= nums[q]) {
                break;
            }
            p++;
        }
        int tmp = nums[p-1];
        nums[p-1] = nums[q];
        nums[q] = tmp;

        reverse(nums, q+1);
    }

    private void reverse(int[] nums, int start) {
        int right = nums.length - 1;
        int left = start;
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }
}
// @lc code=end
