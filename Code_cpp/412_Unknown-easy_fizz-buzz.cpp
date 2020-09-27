/*
 * @lc app=leetcode.cn id=412 lang=cpp
 *
 * [412] Fizz Buzz
 */

// @lc code=start
#include <vector>
#include <string>
using namespace std;
class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> reStrVector;
        for (int i = 1; i <= n; i++)
        {
            if(i%15 == 0)
                reStrVector.push_back("FizzBuzz");
            else if(i%3 == 0)
                reStrVector.push_back("Fizz");
            else if(i%5 == 0)
                reStrVector.push_back("Buzz");
            else 
                reStrVector.push_back(to_string(i));
        }
        return reStrVector;
    }
};
// @lc code=end

