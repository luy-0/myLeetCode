import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.empty()) {
                stack.add(ch);
                continue;
            }
            // else
            if (isMatch(ch, stack.peek())) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        return stack.empty();
    }

    private boolean isMatch(char ch, char peek) {
        if ((peek == '(' && ch == ')') || (peek == '[' && ch == ']') || (peek == '{' && ch == '}')) {
            return true;
        }
        return false;
    }
}
// @lc code=end
