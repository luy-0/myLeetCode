/*
 * @lc app=leetcode.cn id=234 lang=cpp
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode(int x) : val(x), next(NULL) {}
// };
// #include <vector>
// using namespace std;
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(head == nullptr || head->next == nullptr)
            return true;
        vector<int> a;
        while(head){
            a.push_back(head->val);
            head = head->next;
        }
        int left = 0, right = a.size()-1;
        while(left<right)
            if(a[left++] != a[right--])
                return false;
        return true;
    }
};
// @lc code=end

