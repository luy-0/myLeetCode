/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        int len = nums.length;
        for (int first = 0; first < len; first++) {
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = len - 1;
            while (second < third) {
                int tmp3sum = nums[first] + nums[second] + nums[third];
                int tmpDiff = Math.abs(tmp3sum - target);

                if (tmpDiff < diff) {
                    ans = tmp3sum;
                    diff = tmpDiff;
                } else {
                    if (tmp3sum == target) {
                        return tmp3sum;
                    }
                }

                if (tmp3sum > target) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
