public class Offer22 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 链表不存在 或者 k 过小
        if (head == null || k < 1) {
            return null;
        }
        ListNode dumb = new ListNode(0);
        dumb.next = head;

        ListNode fast = dumb;
        ListNode slow = dumb;
        for (int i = 0; i < k; i++) {
            if(fast.next != null){
                fast = fast.next;
            }else{
                // K 过大
                return null;
            }
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(new Offer22().getKthFromEnd(head, 1).val);
    }
}