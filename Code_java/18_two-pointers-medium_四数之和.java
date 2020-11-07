import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length - 3; first++) {
            // 如果first非首个,且与前一个first相同,过
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 判断第一个数是否合适
            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            if (nums[first] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }

            int target3Sum = target - nums[first];

            for (int second = first + 1; second < length - 2; second++) {
                // 如果second非首个,且与前一个secondt相同,过
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 如果第二个数是否合适
                if (nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }
                if (nums[first] + nums[second] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }

                int target2Sum = target3Sum - nums[second];
                int forth = length - 1;
                for (int third = second + 1; third < length - 1; third++) {
                    // 如果third非首个,且与前一个third相同,过
                    if (third != second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    while (third < forth && nums[third] + nums[forth] > target2Sum) {
                        forth--;
                    }
                    if (third == forth) {
                        continue;
                    }
                    if (nums[third] + nums[forth] == target2Sum) {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[forth]));
                    }
                }
            }
        }
        return ans;
    }
}

// @lc code=end
