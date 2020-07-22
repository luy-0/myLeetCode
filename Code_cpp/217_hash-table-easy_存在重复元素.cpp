/*
 * @lc app=leetcode.cn id=217 lang=cpp
 *
 * [217] 存在重复元素
 */

// @lc code=start
#include <map>
#include <vector>
using namespace std;
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        map<int,int> m;
        for (int i :nums)
        {
            if(m.find(i)!=m.end())
                return true;    //找到了
            else    //没找到
                m.insert({i,1});
        }
        return false;
    }
};
// @lc code=end