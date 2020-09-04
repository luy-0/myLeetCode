/*
 * @lc app=leetcode.cn id=344 lang=cpp
 *
 * [344] 反转字符串
 */

// @lc code=start

// #include <vector>
// using namespace std;
class Solution {
public:
    void reverseString(vector<char>& s) {
        int left = 0;
        int right = s.size()-1;
        char tmp = '0';
        while(left < right){
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
};

/* 小技巧: 3次异或交换
s[left] ^= s[right]
s[right] ^= s[left]
s[left] ^= s[right]
即可实现两个元素交换,且不用花费额外空间,还快
 */
// @lc code=end

