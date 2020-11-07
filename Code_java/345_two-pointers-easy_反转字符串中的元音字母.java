import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'o' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'A' || ch == 'O' || ch == 'E'
                || ch == 'I' || ch == 'U';

    }

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            if (!isVowel(charArray[left])) {
                left++;
                continue;
            }
            if (!isVowel(charArray[right])) {
                right--;
                continue;
            }
            char tmp = charArray[left];
            charArray[left++] = charArray[right];
            charArray[right--] = tmp;
        }
        return new String(charArray);
    }
}
// @lc code=end
