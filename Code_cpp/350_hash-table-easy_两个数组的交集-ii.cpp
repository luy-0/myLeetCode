/*
 * @lc app=leetcode.cn id=350 lang=cpp
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
#include <vector>
#include <map>
#include <iostream>
using namespace std;

/* 调试函数
void printMap(const map<int,int> m1){
    cout<<"开始打印map\n";
    for(const auto&i:m1)
        cout<<i.first<<"\t"<<i.second<<endl;
    cout<<"打印完毕map\n";
} */

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        map<int,int> m1;
        map<int,int> m2;
        vector<int> reVector;
        //两个vector转为map 值为出现的次数
        for (int i:nums1)
        {
            auto it = m1.find(i);
            if(it==m1.end())
                m1.insert({i,1});
            else
                it->second++;
        }
        for (int i:nums2)
        {
            auto it = m2.find(i);
            if(it==m2.end())
                m2.insert({i,1});
            else
                it->second++;
        }
        
        /* 
        printMap(m1);
        printMap(m2); */
        
        /* 比较并输出
        map1中每个元素在map2中寻找,找到则向reVector中输出恰当的个数
         */
        for(const auto &it1:m1){
            auto it2 = m2.find(it1.first);
            if(it2==m2.end())continue;

            int time_of_same_num = (it1.second>it2->second)?it2->second:it1.second;
            for(int i = 0;i<time_of_same_num;i++)
                reVector.insert(reVector.end(),it1.first);
        }
        return reVector;
    }
};
// @lc code=end

