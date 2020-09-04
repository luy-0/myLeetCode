/*
 * @lc app=leetcode.cn id=125 lang=cpp
 *
 * [125] 验证回文串
 */

// @lc code=start
// 双指针
class Solution {
public:
    bool isPalindrome(string s) {
        int len = s.size();
        int left = 0, right = len-1;
        
        while(left<right){
            if(!isalnum(s[left])){
                left++;
                continue;
            }
            if(!isalnum(s[right])){
                right--;
                continue;
            }
            if(tolower(s[left]) == tolower(s[right]))
            {
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }
};
// @lc code=end

