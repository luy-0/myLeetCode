/*
 * @lc app=leetcode.cn id=38 lang=cpp
 *
 * [38] 外观数列
 */

// @lc code=start
// #include <string>
// #include <vector>
// #include <iostream>
// using namespace std;
class Solution {
public:
    string countAndSay(int n) {
        if(n == 1) return "1";
        string s = countAndSay(n-1);
        vector<char> v;
        int len = s.size();
        char curr_ch = s[0];
        int num_repeat = 0;
        for(int i=0; i<len;i++){
            if(s[i]!=curr_ch && i!=0){
                v.push_back(num_repeat+'0');
                v.push_back(curr_ch);
                num_repeat = 1;
                curr_ch = s[i];
            }
            else
                num_repeat++;
        }
        v.push_back(num_repeat+'0');
        v.push_back(curr_ch);
        string re;
        re.assign(v.begin(),v.end());
        return re;
    }
};

// int main(int argc, char const *argv[])
// {
//     Solution* my = new Solution();
//     int n = 7;
//     // cout<<my->countAndSay(n);
//     return 0;
// }

// @lc code=end

