import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
// 无敌单纯的排序做法
/* class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
} */

// 利用符号的转变来存储是否出现过的信息
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        /*
         * 思考: 考虑到1 ≤ a[i] ≤ n ,那么应该是一一对应的. 问题:如何将这个信息存储在原有的数组中?能否不影响数组本身信息的存储?
         * 答:由于数字都是正数,我们可以利用符号的转变来存储这一二进制信息(正:未遇见过,负:已遇见过)
         */
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(Math.abs(nums[i]));
                continue;
            } 
            nums[index] = -nums[index];
        }
        return ans;
    }
}
// @lc code=end
