/*
 * @lc app=leetcode.cn id=217 lang=cpp
 *
 * [217] 存在重复元素
 */

// @lc code=start
#include <vector>
#include <iostream>
using namespace std;
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        
    }
};

/* 错误解法:使用同或运算 失败
bool containsDuplicate(vector<int>& nums) {
        if(nums.size()==0)return 0;
        int res = nums[0];
        for(auto it = nums.begin()+1;it!=nums.end();++it)
        
            res = !(res^*it);
        return !res;
    }
     */
// int main(int argc, char const *argv[])
// {
//     Solution s;
//     vector<int> v;
//     bool c = true;
//     bool b = s.containsDuplicate(v);
//     cout<<b<<c;
//     return 0;
// }

// @lc code=end

