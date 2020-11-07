/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s == "" || t == "") {
            return "";
        }
        // 统计字串的每个字符的出现次数
        // 注: 128是char类型的总数,实际上只需要26个数组即可
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        // 用于统计窗口中的出现的字符次数.
        int[] window = new int[128];

        int left = 0, right = 0;
        int minLength = s.length() + 1;
        int targetLeft = Integer.MIN_VALUE;
        int count = 0;

        String res = "";

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (need[ch] > 0 && need[ch] >= window[ch]) {
                count++;
            }

            while (count == t.length()) {
                ch = s.charAt(left);
                if (need[ch] > 0 && need[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    // res = s.substring(left, right + 1);
                    targetLeft = left;
                }
                window[ch]--;
                left++;
            }
            right++;
        }
        res = (targetLeft == Integer.MIN_VALUE) ? "" : s.substring(targetLeft, targetLeft + minLength);
        return res;
    }
}
// @lc code=end
