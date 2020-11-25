import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }

/**
 * 解法1 哈希表记录状态
 */
/*
 * public class Solution { public ListNode detectCycle(ListNode head) { ListNode
 * pos = head; Set<ListNode> set = new HashSet<ListNode>(); while(pos!=null){
 * if(set.contains(pos)){ return pos; }else{ set.add(pos); } pos = pos.next; }
 * return null; } }
 */

/**
 * 解法2 快慢指针 很神奇
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode pos = head;
                while(slow!=pos){
                    slow=slow.next;
                    pos=pos.next;
                }
                return pos;
            }
        }
        return null;

    }
}

// @lc code=end
