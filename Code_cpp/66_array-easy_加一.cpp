/*
 * @lc app=leetcode.cn id=66 lang=cpp
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (44.54%)
 * Likes:    489
 * Dislikes: 0
 * Total Accepted:    169.8K
 * Total Submissions: 381.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
#include <vector>
#include <iostream>
using namespace std;
/* 解法1 数学解题  t-100 s-6

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int len = digits.size();
        for (int i = len-1; i >= 0; --i)
        {
            if (digits[i]<9)
            {
                digits[i]++;
                return digits;
                //本位自加
            }
            if (i==0)
            {
                digits[0]=1;
                digits.push_back(0);
                //第一位为9(事实上全是9)
            }
            else 
                digits[i] = 0;
                //非第一位为9
        }
        return digits;
    }
};
*/

/* 解法2 Vector转整数再转Vector 失败 大数无法储存

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) 
    {
        long long times = 1;
        long long number = 0;
        for(int i = digits.size()-1;i>=0;i--,times*=10)
        {
            number += ((long long)digits[i])*times;
        }
        number+=1;
        digits.clear();
        while (1)
        {
            digits.insert(digits.begin(),number%10);
            number/=10;
            if(number==0) break;
        }
        
        return digits;
    }
};
*/
// @lc code=end

