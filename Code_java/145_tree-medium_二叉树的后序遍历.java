import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
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

/**
 * 递归
 */
/*
 * class Solution { private List<Integer> helper(TreeNode root, List<Integer>
 * ans){ if(root==null){ return ans; } ans = helper(root.left, ans); ans =
 * helper(root.right, ans); ans.add(root.val); return ans; } public
 * List<Integer> postorderTraversal(TreeNode root) { List<Integer> ans = new
 * ArrayList<>(); return helper(root, ans); } }
 */

/**
 * 迭代
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push((root));
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || prev == root.right) {
                ans.add(root.val);
                stack.pop();
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}

// @lc code=end
