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
/* 解法1 暴力 t_6 s_100 */
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
/* 解法1 over */
// @lc code=end

