import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/**
 * 递归算法
 * 
 */
/* class Solution {
    private List<Integer> helper(TreeNode node,List<Integer> ans){
        if(node==null){
            return new ArrayList<Integer>();
        }
        ans.add(node.val);
        helper(node.left, ans);
        helper(node.right, ans);
        return ans;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return helper(root, ans);
    }
} */

/**迭代算法 */

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty()){
            TreeNode tmpNode = stack.pop();
            ans.add(tmpNode.val);
            if(tmpNode.right!=null){
                stack.add(tmpNode.right);
            }
            if(tmpNode.left!=null){
                stack.add(tmpNode.left);
            }
        }
        return ans;
    }
}

// @lc code=end

