/*
 * @lc app=leetcode.cn id=7 lang=cpp
 *
 * [7] 整数反转
 */
// #include <limits.h>
// @lc code=start
class Solution {
public:
    int reverse(int x) {
        int re = 0;
        while(x!=0){
            int pop = x%10;
            x /= 10;
            if(re>INT_MAX/10 || (re == INT_MAX && pop>7))return 0;
            if(re < INT_MIN/10 || (re == INT_MIN && pop<-8))return 0;
            re = re*10 + pop;
        }
        return re;
    }
};
// @lc code=end

