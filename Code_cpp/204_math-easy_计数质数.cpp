/*
 * @lc app=leetcode.cn id=204 lang=cpp
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
public:
    int isPrimes(int m){
        for (int i = 2; i*i <= m; i++)
            if(m%i == 0)
                return 0;
        return 1;
        
    }
    int countPrimes(int n) {
        if(n<3) return 0;
        int re = 1;
        for (int i = 3; i < n; i++)
            re += isPrimes(i);
        return re;
    }
};
// @lc code=end

