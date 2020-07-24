/*
 * @lc app=leetcode.cn id=136 lang=cpp
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
#include <vector>
#include <map>
using namespace std;
/* 解法1 hash t-10 s-6*/
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

/* hash优化 t-6 s-6 失败的优化 建议忽略
应该是因为map本身的函数花费的时间更长吧*/
// class Solution {
// public:
//     int singleNumber(vector<int>& nums) {
//         map<int,int> m; 
//         int sum = 0;
//         for (int i : nums)
//         {
//             auto it = m.find(i);
//             if (it==m.end())
//             {
//                 sum+=i;
//                 m.insert({i,1});
//             }
//             else
//                 sum-=i;
//         }
//         return sum;
//     }
// }; 

// @lc code=end

