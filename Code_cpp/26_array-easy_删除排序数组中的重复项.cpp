/*
 * @lc app=leetcode.cn id=26 lang=cpp
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
#include <vector>
using namespace std;
/* 
数组是排好序的. 若后一个与前一个相同,则表明重复.
 */
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int length = nums.size();
        auto last = nums.end();
        if (nums.begin()==nums.end())
            return 0;
        
        for (auto it = nums.begin()+1; it!=last; ){         //这里直接从第二个元素开始,需要补充元素为0的情况
            if(*it == *(it-1))
            {
                nums.erase(it);
                length--;
                last--;
                //注意erase后每个元素都"前移"了
                //所以这里不能it++
            }else
            {
                it++;
            }
        }
        return length;
    }
};
// @lc code=end

