/*
 * @lc app=leetcode.cn id=136 lang=cpp
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
#include <vector>
#include <map>
using namespace std;
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        map<int,int> m;
        for (int i : nums)
        {
            auto it = m.find(i);
            if (it!=m.end())
            {
                //找到
                it->second=2;
            }else
            {
                m.insert({i,1});
            }
        }
        for (auto &it : m)
        {
            if (it.second == 1)
            {
                return it.first;
            }
        }
        return -1;
    }
};
// @lc code=end

