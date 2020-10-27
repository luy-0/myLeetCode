import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
// 解法1 排序
// class Solution {
//     public int majorityElement(int[] nums) {
//         if (nums.length == 1) {
//             return nums[0];
//         }
//         Arrays.sort(nums);
//         /* 粗劣的排序
//         int lastElem = nums[0];
//         int currNum = 1;
//         int targetNum = nums.length / 2;

//         for (int i = 1; i < nums.length; i++) {
//             if(nums[i]==lastElem){
//                 currNum++;
//                 if(currNum>targetNum){
//                     return nums[i];
//                 }
//             }else{
//                 lastElem = nums[i];
//                 currNum=1;
//             }
//         } */

//         /* 优化的排序
//         排序后,多数元素一定在数组的正中间 */

//         return nums[nums.length/2];
//     }
// }

// 解法2 哈希
/* class Solution {
    public int majorityElement(int[] nums) {
        int targetNum = nums.length/2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if(map.containsKey(i)){
                int currNum = map.get(i);
                map.put(i, ++currNum);
                if(currNum>targetNum){
                    return i;
                }
            }else{
                map.put(i, 1);
            }
        }
        // 如果到这里,说明数组中只有一个元素
        return nums[0];
    }
} */

// 解法3 Boyer-Moore投票算法
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int i : nums) {
            if (count == 0) {
                candidate = i;
                count++;
            } else {
                count += (i == candidate) ? 1 : -1;
            }
        }
        return candidate;
    }
}

// @lc code=end
