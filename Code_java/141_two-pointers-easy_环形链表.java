/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/* class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
} */

/* 解法1: 快慢指针 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode ptr_fast = head.next;
        ListNode ptr_slow = head;
        while(ptr_fast != ptr_slow){
            if(ptr_fast.next == null || ptr_fast.next.next == null){
                return false;
            }
            ptr_fast = ptr_fast.next.next;
            ptr_slow = ptr_slow.next;
        }
        return true;
    }
}
// @lc code=end

