/*
 * @lc app=leetcode.cn id=136 lang=cpp
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
#include <vector>
using namespace std;
/* 解法2 位运算 异或
对于重复两次的数字,a^a=0,而异或运算具有交换性
a^b^c^a^b=c
发现每一次相同的代码跑出来时间都不一样 不要太在意击败多少人了
学到东西最重要
 */
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int res = 0;
        for(int i:nums)
            res = res^i;
        return res;
    }
};
// @lc code=end

