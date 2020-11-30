/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */

// public class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }

/* public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean flagA = true;
        boolean flagB = true;
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) {
                return ptrA;
            }
            // System.out.println(ptrA.val);
            // System.out.println(ptrB.val);
            ptrA = ptrA.next;
            ptrB = ptrB.next;
            if (ptrA == null && flagA) {
                ptrA = headB;
                flagA = false;
            }
            if (ptrB == null && flagB) {
                ptrB = headA;
                flagB = false;
            }
        }
        return null;

    }
} */

/**
 * 算法一致, 优化
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while (ptrA != ptrB) {
            ptrA = (ptrA == null) ? headB : ptrA.next;
            // 如果为空, 说明走到了A的尽头, 转B
            // 不可能会走到B的尽头: 因为那时二者相等, while条件不成立
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }
        return ptrA;

    }
}

// @lc code=end
