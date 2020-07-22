/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 */

// @lc code=start
#include <vector>
#include <iostream>
using namespace std;
// 未完成
class Solution {
public:
    /* 解法1 
    占用额外空间储存数组
    T_5.55    S_5.55
    */
    void rotate(vector<int>& nums, int k) {
        /* 
        分成三步
        1. 储存后k个数
        2. 将前n-k个数后移
        3. 将k个数放至最前 */

        /* k的取值
        k可能给出>数组长度的数,所以提前处理 */
        int length = nums.size();
        if(k>=length)
            k%=length;
        if(k==0)
            return;

        vector<int> kVector;
        auto nums_it = nums.end()-1;
        for(int i=0;i<k;i++){
            kVector.insert(kVector.begin(),*nums_it);
            nums_it--;
        }
        
        for(int i=nums.size()-1;i>=k;i--){
            nums[i]=nums[i-k];
        }

        int j=0;
        for(int i : kVector)
            nums[j++]=i;
    }


};
// @lc code=end

