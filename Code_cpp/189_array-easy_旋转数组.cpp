/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 */

// @lc code=start
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    /* 解法1 额外空间储存数组(不符要求) T_5 S_5
    占用额外空间储存数组
    */
    /* void rotate(vector<int>& nums, int k) {
        // 分成三步
        // 1. 储存后k个数
        // 2. 将前n-k个数后移
        // 3. 将k个数放至最前 

        // k的取值
        // k可能给出>数组长度的数,所以提前处理 
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
 */
    
    /* 解法2 环状替换 t-86 s-5
    
     
    void rotate(vector<int>& nums, int k) {
        int start=0,count=0,len=nums.size();

        k%=len;
        if(!k)return;
        
        for(;count!=len;start++)
        {
            int cur=start,tmp,pre=nums[cur];
            while (1)
            {
                int next = (cur+k)%len;
                tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
                count++;
                if(cur==start) break;
            }
            
        }
    }
    */

    /* 解法3 三重反转 t-86 s-5
    基于数学技巧 自己画个图就看出来三重反转和旋转的效果一样
    */
    void rotate(vector<int>& nums, int k) {
        int len = nums.size();
        k %= len;
        if(!k)return;

        reverse(nums.begin(),nums.end()-k);
        reverse(nums.end()-k,nums.end());
        reverse(nums.begin(),nums.end());
    }

};
// @lc code=end

