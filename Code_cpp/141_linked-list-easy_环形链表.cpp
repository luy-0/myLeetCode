/*
 * @lc app=leetcode.cn id=141 lang=cpp
 *
 * [141] 环形链表
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

// #include <map>
// using namespace std;

// 解法1: 哈希表
/* class Solution {
public:
    bool hasCycle(ListNode *head) {
        map<ListNode*, int> record;
        while(head){
            if(record.find(head)!=record.end())
                return true;
            else{
                record[head]++;
                head = head->next;
            }
                
        }
        return false;
    }
}; */

// 解法2 双指针
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head == nullptr || head->next == nullptr)
            return false;
        ListNode* fNode = head->next;
        ListNode* sNode = head;
        while(fNode != nullptr && fNode->next != nullptr){
            fNode = fNode->next->next;
            sNode = sNode->next;
            if(sNode == fNode)
                return true;
        }
        return false;
    }
};
// @lc code=end

