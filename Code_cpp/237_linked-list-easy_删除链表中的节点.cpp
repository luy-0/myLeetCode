/*
 * @lc app=leetcode.cn id=237 lang=cpp
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/* *
 * Definition for singly-linked list.*/
/* struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
}; */

/* 
传入参数仅为要删除的节点, (保证不是最后一个节点, 保证链表有两个及以上节点)

最初的思路自然是**将前驱节点的指针指向后继节点**, 但是无法取得前驱节点.

正确的思路: **将本节点赋值为后继节点, 并删去后继节点
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
        node->val = node->next->val;
        node->next = node->next->next;
    }
};
// @lc code=end

