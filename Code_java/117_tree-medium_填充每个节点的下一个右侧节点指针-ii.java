/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/* class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}; */

/*
 * class Solution { public Node connect(Node root) { if (root == null) { return
 * root; }
 * 
 * Queue<Node> queue = new LinkedList<>(); queue.add(root);
 * 
 * while (!queue.isEmpty()) { int currSize = queue.size(); for (int i = 0; i <
 * currSize - 1; i++) { Node tmp = queue.poll(); tmp.next = queue.peek(); if
 * (tmp.left != null) queue.add(tmp.left); if (tmp.right != null)
 * queue.add(tmp.right); } Node tmp = queue.poll(); if (tmp.left != null)
 * queue.add(tmp.left); if (tmp.right != null) queue.add(tmp.right); } return
 * root; } }
 */

class Solution {
    private Node currNode;
    private Node nextLevelFirstNode;

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node thisLevelFirstNode = root;

        while (thisLevelFirstNode != null) {
            nextLevelFirstNode = null;
            currNode = null;
            for (Node p = thisLevelFirstNode; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            thisLevelFirstNode = nextLevelFirstNode;
        }
        return root;
    }

    private void handle(Node node) {
        if (nextLevelFirstNode == null) {
            nextLevelFirstNode = node;
        }
        if (currNode != null) {
            currNode.next = node;
        }
        currNode = node;
    }
}

// @lc code=end
