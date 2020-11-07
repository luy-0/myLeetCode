import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
 * class Solution { public List<List<Integer>> levelOrder(TreeNode root) {
 * List<List<Integer>> ans = new ArrayList<>(); List<Integer> levelList = new
 * ArrayList<>();
 * 
 * if (root == null) { return ans; }
 * 
 * Queue<TreeNode> hightQueue = new LinkedList<>(); Queue<TreeNode> lowQueue =
 * new LinkedList<>();
 * 
 * hightQueue.add(root); while (!hightQueue.isEmpty()) { TreeNode curTreeNode =
 * hightQueue.poll(); levelList.add(curTreeNode.val); if (curTreeNode.left !=
 * null) { lowQueue.add(curTreeNode.left); } if (curTreeNode.right != null) {
 * lowQueue.add(curTreeNode.right); } if (hightQueue.isEmpty()) {
 * hightQueue.addAll(lowQueue); lowQueue.clear(); List<Integer> tmp = new
 * ArrayList<>(); tmp.addAll(levelList); ans.add(tmp); levelList.clear(); } }
 * return ans; } }
 */

/** 优化 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int curLength = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < curLength; i++) {
                TreeNode curNode = queue.poll();
                level.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
// @lc code=end
