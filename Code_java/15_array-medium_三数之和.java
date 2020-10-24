import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len; first++) {
            // 如果first(在非首个时)和前一个相同,直接过
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 如果nums[first]过大,肯定无解.(因为second,third的数更大)
            if (nums[first] > 0) {
                continue;
            }

            int third = len - 1;
            int target = -1 * nums[first];
            for (int second = first + 1; second < len; second++) {
                // second(在非首个时)和前一个相同,直接过
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 如果nums[second]过大,肯定无解.(因为third更大)
                if (nums[second] > target) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 现在的情况是:要么second,third撞在一起,表明该first没有合适的数使得和为0,那么下一个first;要么nums[second]+nums[third]<=target,表示可能有合适的解(小于说明无解,等于说明有解)
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
                // 否则,nums[second]+nums[third]==target,表明对应的secend没有合适的third,使得和为0;那么就下一个(second++)
            }
        }
        return ans;
    }
}
// @lc code=end
