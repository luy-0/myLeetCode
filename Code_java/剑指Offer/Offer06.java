import java.util.Stack;

public class Offer06 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] reversePrint_1(ListNode head) {
            if (head == null) {
                return new int[0];
            }
            int len = 1;
            ListNode node = head;
            while (node.next != null) {
                node = node.next;
                len++;
            }
            node = head;
            int[] ans = new int[len];
            for (int i = len - 1; i >= 0; i--) {
                ans[i] = node.val;
                node = node.next;
            }
            return ans;
        }

        public int[] reversePrint_2(ListNode head) {
            if (head == null) {
                return new int[0];
            }
            Stack<ListNode> stack = new Stack<>();
            ListNode node = head;
            while (node != null) {
                stack.push(node);
                node = node.next;
            }
            int[] ans = new int[stack.size()];
            int index = 0;
            while (!stack.empty()) {
                ans[index++] = stack.pop().val;
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }

}