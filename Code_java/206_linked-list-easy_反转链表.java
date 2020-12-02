/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//  public class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//     }
// }
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode post = head.next;

        while(post!=null){
            curr.next=pre;
            pre = curr;
            curr = post;
            post = post.next;
        }
        curr.next=pre;
        return curr;
    }
}
// @lc code=end

