/*
 * @lc app=leetcode.cn id=14 lang=cpp
 *
 * [14] 最长公共前缀
 */

// @lc code=start
#include <vector>
#include <string>

using namespace std;
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(!strs.size())
            return "";
        
        int matchNum = 0;
        int strLength = strs[0].size();
        for (int i = 0; i < strLength; i++,matchNum++)
        {
            char curr_char = strs[0][i];
            for(int j = 0;j<strs.size();j++)
            {
                if(matchNum == strLength || curr_char != strs[j][i])
                    return strs[0].substr(0,matchNum);
            }
        }
        return strs[0];
    }
};
// @lc code=end

