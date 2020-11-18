import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode(int x) {
// val = x;
// }
// }
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer str = new StringBuffer();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                str.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                str.append("null,");
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] val = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!val[cur].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(val[cur]));
                queue.add(node.left);
            }
            cur++;
            if (!val[cur].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(val[cur]));
                queue.add(node.right);
            }
            cur++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
