/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 */

// @lc code=start
#include <vector>
using namespace std;

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
    /* 思路1
    扫描0,删去并计数,末尾添0 */
        int numZero = 0;
        for (vector<int>::iterator it = nums.begin(); it!=nums.end();)
        {
            if (*it==0)
            {
                nums.erase(it);
                numZero++;
            }
            else
            {
                ++it;
                //如果删去了这个元素,it不应后移
            }
        }
        nums.insert(nums.end(),numZero,0);
        /* insert(element,fill,range)
         http://www.cplusplus.com/reference/vector/vector/insert/
         */
    }
};
// @lc code=end

