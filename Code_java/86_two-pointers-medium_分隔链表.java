import java.util.List;

/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */


/**
 * 命名这两个区间:小于x的为区间A, 大于等于x的为区间B 两个指针,一个在A的最后一个元素.另一个在区间B的后面一个元素(也就是还没处理的元素)
 */
class Solution {

    class Solution {
   
        private void print(ListNode head){
             String ans = "[";
             while (head!=null) {
                 ans += ""+head.val+",";
                 head=head.next;
             }
             ans+="]";
             System.out.println(ans);
         }
     
         public ListNode partition(ListNode head, int x) {
             if(head==null){
                 return head;
             }
             ListNode fListNode = new ListNode(0);
             fListNode.next = head;
             ListNode splitNode = fListNode;
             ListNode currNode = head;
             ListNode endNoode = fListNode;
             System.out.println("splitNode:"+splitNode.val);
             System.out.println("currNode:"+currNode.val);
             System.out.println("endNoode:"+endNoode.val);
             while(endNoode.next!=null){
                 if (currNode.val < x) {
                     //System.out.println("flag:");
                     // 若小于x,将这个结点移到前面.
                     if(splitNode==endNoode){
                         splitNode=currNode;
                         endNoode=currNode;
                         currNode=currNode.next;
                     }else{
                         endNoode.next = currNode.next;
                         currNode.next = splitNode.next;
                         splitNode.next = currNode;
                         splitNode = currNode;
                         if(endNoode.next!=null)
                             currNode = endNoode.next;
                     }
     
                     
                     print(fListNode.next);
                     System.out.println("endNoode:"+endNoode.val);
                     System.out.println("splitNode:"+splitNode.val);
                     if(currNode!=null)
                         System.out.println("currNode:"+currNode.val);
                 }else{
                     // 若>=x,不需要特殊操作.
                     endNoode = currNode;
                     if(endNoode.next!=null)
                         currNode = currNode.next;
                     print(fListNode.next);
                     
                 }
             }
             return fListNode.next;
         }
     }
}
// @lc code=end
