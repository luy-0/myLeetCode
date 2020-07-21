/*
 * @lc app=leetcode.cn id=48 lang=cpp
 *
 * [48] 旋转图像
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
    /* 思路1:
    先转置, 再对称*/
        int len = matrix.size();
        //转置
        for (int i = 0; i < len-1; i++)
        {
            for (int j = i+1; j < len; j++)
            {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
            
        }
        //对称
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len/2; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = tmp;
            }
        }
    }
};
// @lc code=end

