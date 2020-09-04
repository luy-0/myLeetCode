/*
 * @lc app=leetcode.cn id=387 lang=cpp
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
#include <map>
#include <string>
using namespace std;
/* 解法一,hash+两次遍历
class Solution {
public:
    int firstUniqChar(string s) {
        int length = s.size();
        map<char,int> m;

        for(int i = 0; i<length; i++){
            char ch = s[i];
            if(m.find(ch) != m.end())
                m.find(ch)->second++;
            else
                m.insert({ch,1});
        }

        for(int i = 0; i<length; i++){
            char ch = s[i];
            if(m.find(ch)->second == 1)
                return i;
        }
        return -1;
    }
}; */

// 解法二,不借助hash
// 该字符第一次出现的位置和最后一次出现的位置一样，就证明不重复。
// 并且进行了优化, 无论字符串多长都只需要26次循环(常数级优化)
class Solution {
public:
    int firstUniqChar(string s) {
        int length = s.size();
        if (length<26){
            for(int i = 0;i<length;i++){
                char c = s[i];
                int pre = s.find_first_of(c);
                if(pre!=-1 && pre==s.find_last_of(c))
                    return pre;
            }
            return -1;
        }

        int result = -1;
        for(char c = 'a';c<='z';c++){
            int pre = s.find_first_of(c);
            if(pre!=-1 && pre==s.find_last_of(c))
                result = (result == -1 || result>pre)?pre:result;
        }
        return result;
    }
};

// @lc code=end

