/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// public class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//     }
// }

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        

        ListNode second = head;
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if(first == null){
            // 如果这时lastNode就是null
            //     说明删除的是头节点
            return head.next;
        }
        while(first.next!=null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return head;
    }
}
// @lc code=end
