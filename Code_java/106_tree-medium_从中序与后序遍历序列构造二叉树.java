import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

    TreeNode(int x) {
        val = x;
    }
}

/*
 * 从中序与后序遍历序列构造二叉树 后序的最后一个数字是根节点,然后依次是其右子树和左子树 中序的中间某个数组是根节点,左右依次是其左子树和右子树
 * 
 */
class Solution {
    private TreeNode helper(List<Integer> inList, List<Integer> postList) {
        int val = postList.remove(postList.size() - 1);
        TreeNode node = new TreeNode(val);
        int index = inList.indexOf(val);
        if (index != inList.size() - 1) {
            node.right = helper(inList.subList(index + 1, inList.size()), postList);
        }
        if (index != 0) {
            node.left = helper(inList.subList(0, index), postList);
        }
        return node;
    };

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> postList = Arrays.stream(postorder).boxed().collect(Collectors.toList());

        return helper(inList, postList);

    }
}
// @lc code=end
