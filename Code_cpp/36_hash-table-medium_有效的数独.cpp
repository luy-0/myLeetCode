/*
 * @lc app=leetcode.cn id=36 lang=cpp
 *
 * [36] 有效的数独
 */

// @lc code=start
#include <vector>
#include <iostream>
#include <map>
using namespace std;
/* 解法1 暴力哈希一次遍历 t_6 s_100 建议直接看优化部分 
维度有3个：所在的行，所在的列，所在的box
遍历到每个数的时候，例如boar[i][j]，我们判断其是否满足三个条件：

在第 i 个行中是否出现过
在第 j 个列中是否出现过
在其subbox中是否出现过

如果出现过,数独无效,否则标记之.

int getSubBoxNum(int row,int col){
    if(row<3)
        if(col<3)
            return 0;
        else
        if(col>5)
            return 2;
        else
            return 1;
    else
    if(row>5)
        if(col<3)
            return 6;
        else
        if(col>5)
            return 8;
        else
            return 7;
    else
        if(col<3)
            return 3;
        else
        if(col>5)
            return 5;
        else
            return 4;

}

bool checkInMap(char cc,map<char,int>& mm){
    auto it = mm.find(cc);
    if(it==mm.end())
        mm.insert({cc,1});
    else
        return true;
    return false;
}

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        map<char,int> colMap[9];
        map<char,int> rawMap[9];
        map<char,int> subMap[9];

        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch=='.')continue;
                if(checkInMap(ch,rawMap[i]))
                    return false;
                    else
                if(checkInMap(ch,colMap[j]))
                    return false;
                if(checkInMap(ch,subMap[getSubBoxNum(i,j)]))
                    return false;
            }
        return true;
    }
};
*/

/* 解法1优化 t-92 s-100
使用了二维数组而不是map实现hash
对于 getSubBoxNum() 功能只需要表达式 $(i/3)*3+j/3$ 即可完成;
优化了 checkInMap() ,现在只需要几行代码
同样的思路, 不同的实现也导致效率大不同
 */

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int raw[9][10] = {0};
        int col[9][10] = {0};
        int sub[9][10] = {0};

        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch=='.')continue;
                int current = ch - '0';

                if(raw[i][current])
                    return false;
                else
                    raw[i][current]=1;
                if(col[j][current])
                    return false;
                else
                    col[j][current]=1;
                if(sub[(i/3)*3+j/3][current])
                    return false;
                else
                    sub[(i/3)*3+j/3][current]=1;
            }
        return true;
    }
};
// @lc code=end

