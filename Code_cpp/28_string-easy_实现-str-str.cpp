/*
 * @lc app=leetcode.cn id=28 lang=cpp
 *
 * [28] 实现 strStr()
 */

// @lc code=start
#include <string>
#include <iostream>
using namespace std;
class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle=="")
            return 0;
        int subLength = needle.size();
        int supLength = haystack.size();
        for(int i=0;i<supLength-subLength+1;i++)
        {
            if(haystack[i]!=needle[0])
                continue;
            string strFromSup = haystack.substr(i,subLength);
            if(!needle.compare(strFromSup))
                return i;
        }   
        return -1;
    }
};
// @lc code=end

