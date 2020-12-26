/**
 * 说明: 本题原书与力扣上的题目不一致,采用原书的题目: 在 O(1)的时间内删除指定的链表节点
 */
public class Offer18 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, ListNode node) {
        if (head == null || head.next == null) {
            // 如果链表中只有一个节点,删除后为空
            return null;
        }
        if (node.next != null) {
            // 如果要删除的节点不是尾节点
            node.val = node.next.val;
            node.next = node.next.next;
        } else {
            ListNode preNode = head;
            while (head.next != node) {
                preNode = preNode.next;
            }
            preNode.next = null;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}