/*
 * @lc app=leetcode.cn id=206 lang=cpp
 *
 * [206] 反转链表
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

/* struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
}; */

//  解法1-反向复制
/* class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr)    return head;
        ListNode* pre = new ListNode(head->val);
        ListNode* cur = head->next ;
        while(cur){
            ListNode* tmp = new ListNode(cur->val);
            tmp->next = pre;
            pre = tmp;
            cur = cur->next;
        }
        return pre;
    }
}; */

//解法2-原地反转
/* class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr)    return head;
        ListNode* pre = nullptr;
        ListNode* cur = head;
        ListNode* next = nullptr;
        while (cur)
        {
            next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}; */

// 解法3 递归
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) 
            return head;
        ListNode* p = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return p;
    }
};
// @lc code=end

