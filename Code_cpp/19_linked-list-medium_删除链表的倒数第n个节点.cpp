/*
 * @lc app=leetcode.cn id=19 lang=cpp
 *
 * [19] 删除链表的倒数第N个节点
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

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head) return head;
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode *f_node = dummy;
        ListNode *s_node = dummy;
        for (size_t i = 0; i < n; i++)
            f_node = f_node->next;
        while(f_node->next){
            f_node = f_node->next;
            s_node = s_node->next;
        }
        s_node->next = s_node->next->next;
        ListNode* re = dummy->next;
        delete dummy;
        return re;
    }
};
// @lc code=end

