/*
 * @lc app=leetcode.cn id=26 lang=cpp
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
#include <vector>
#include <iostream>
using namespace std;
/* 解法2 双指针 t_90 s_100
数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。只要 nums[i]=nums[j]，我们就增加 j 以跳过重复项。

当我们遇到 nums[j] != nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
*/
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i=0,j=0,length=nums.size();
        if(length==0)
            return 0;
        while(j<length){
            if (nums[i]!=nums[j])
                nums[++i]=nums[j];
            j++;
        }
        return i+1;
    }
};
// @lc code=end

