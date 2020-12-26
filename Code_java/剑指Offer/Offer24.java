public class Offer24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode pre = dumb;
        ListNode curr = head;
        ListNode post = head.next;
        while (post != null) {
            curr.next = pre;
            pre = curr;
            curr = post;
            post = post.next;
        }
        curr.next = pre;
        head.next = null;
        return curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;node2.next=node3;node3.next=node4;node4.next=node5;
        new Offer24().reverseList(head).print();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        return super.toString()+"#"+val;
    }
    public void print(){
        System.out.printf("%d,",val);
        if(next!=null){
            next.print();
        }
    }
}