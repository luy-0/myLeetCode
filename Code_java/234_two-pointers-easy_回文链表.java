import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> iList = new ArrayList<>();

        while (head != null) {
            iList.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = iList.size()-1;
        while (i<j) {
            if(iList.get(i).equals(iList.get(j))){
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}
// @lc code=end
