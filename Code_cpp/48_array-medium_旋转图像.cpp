/*
 * @lc app=leetcode.cn id=48 lang=cpp
 *
 * [48] 旋转图像
 */

// @lc code=start
#include <vector>
using namespace std;
/* 解法1:先转置, 再对称 双百
    (i,j)->(j,n-1-i)
*/
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
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

/* 解法1优化 双百 更简洁

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int len=matrix.size(),high,low;
        for(int i=0;i<len;i++)
            for(int j=i;j<len;j++)    
                swap( matrix[i][j],matrix[j][i]);
        //转置,使用stl中的swap
        for(int i=0;i<len;i++)
        {
            low=0;high=len-1;
            while(low<high)    
                swap( matrix[i][low++],matrix[i][high--]);
            //对称,类似双指针?
        }
    }
};
*/

// @lc code=end

