/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
// 先用暴力写一遍试试
class Solution {
    private double getMedianElem(int[] nums){
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        else {
            if(len%2 == 0){
                return (nums[len/2] + nums[len/2-1]) / 2.0;
            }
            else{
                return nums[len/2];
            }
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0){
            return getMedianElem(nums2);
        }
        if(nums2.length == 0){
            return getMedianElem(nums1);
        }

        int[] new_nums = new int[nums1.length+nums2.length];
        int count = 0;
        int i = 0,j = 0;
        while(count != nums1.length + nums2.length){
            if(i == nums1.length){
                while(j != nums2.length){
                    new_nums[count++] = nums2[j++];
                }
                break;
            }
            if(j == nums2.length){
                while(i != nums1.length){
                    new_nums[count++] = nums1[i++];
                }
                break;
            }

            if(nums1[i]<nums2[j]){
                new_nums[count++] = nums1[i++];
            }
            else{
                new_nums[count++] = nums2[j++];
            }
        }
        return getMedianElem(new_nums);

    }
}
// @lc code=end

