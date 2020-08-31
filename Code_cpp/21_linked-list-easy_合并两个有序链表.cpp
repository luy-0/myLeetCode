/*
 * @lc app=leetcode.cn id=21 lang=cpp
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode() : val(0), next(nullptr) {}
//     ListNode(int x) : val(x), next(nullptr) {}
//     ListNode(int x, ListNode *next) : val(x), next(next) {}
// };
  
//  解法1 迭代比较
// class Solution {
// public:
//     ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
//         ListNode* head;
//         ListNode* curr;
//         if(l1 == nullptr)
//             return l2;
//         if(l2 == nullptr)
//             return l1;
//         if(l1->val <= l2->val){
//             head = l1;
//             l1 = l1->next;
//         }
//         else{
//             head = l2;
//             l2 = l2->next;
//         }
//         curr = head;
//         while (l1 != nullptr && l2 != nullptr){
//             if(l1->val <= l2->val){
//                 curr->next = l1;
//                 curr = l1;
//                 l1 = l1->next;
//             }
//             else{
//                 curr->next = l2;
//                 curr = l2;
//                 l2 = l2->next;
//             }
//         }
//         if(l1 == nullptr)
//             curr->next = l2;
//         else
//             curr->next = l1;
//         return head;
//     }
// };

// 解法二 递归
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(l1 == nullptr)
            return l2;
        if(l2 == nullptr)
            return l1;
        if (l1->val <= l2 ->val){
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        }else
        {
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
    }
};
// @lc code=end

