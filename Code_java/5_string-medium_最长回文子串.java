/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 1;
        int beginIndex = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length() ; j++) {
                if(j-i+1 > maxlen && isPalindrome(charArray, i ,j)){
                    maxlen = j-i+1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxlen);
    }

    private boolean isPalindrome(char[] ch , int l, int r){
        while(l<r){
            if(ch[l] != ch[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
// @lc code=end

