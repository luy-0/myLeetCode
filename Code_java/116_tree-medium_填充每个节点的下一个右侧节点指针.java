import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start

// Definition for a Node.
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
/**
 * 层序遍历.
 */
// class Solution {
//     public Node connect(Node root) {
//         if (root == null) {
//             return root;
//         }

//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);

//         while (!queue.isEmpty()) {
//             int currSize = queue.size();
//             for (int i = 0; i < currSize - 1; i++) {
//                 Node tmp = queue.poll();
//                 tmp.next = queue.peek();
//                 if (tmp.left != null)
//                     queue.add(tmp.left);
//                 if (tmp.right != null)
//                     queue.add(tmp.right);
//             }
//             Node tmp = queue.poll();
//             if (tmp.left != null)
//                 queue.add(tmp.left);
//             if (tmp.right != null)
//                 queue.add(tmp.right);
//         }
//         return root;
//     }
// }

/**
 * 递归
 */
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node levelFirstNode = root;
        while (levelFirstNode.left != null) {
            Node currNode = levelFirstNode;

            while (currNode != null) {
                currNode.left.next = currNode.right;
                if (currNode.next != null) {
                    currNode.right.next = currNode.next.left;
                }
                currNode = currNode.next;
            }
            levelFirstNode = levelFirstNode.left;
        }
        return root;
    }
}

// @lc code=end
