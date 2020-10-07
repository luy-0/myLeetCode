/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int strLength = strs[0].length();
        for (int i = 0; i < strLength; i++) {
            char curr_char = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || curr_char !=strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];

    }
}
// @lc code=end

