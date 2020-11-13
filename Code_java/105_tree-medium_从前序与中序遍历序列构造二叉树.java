import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
 * 从中序与前序遍历序列构造二叉树 
 * 前序的第一个数字是根节点,然后依次是其左子树和右子树 中序的中间某个数组是根节点,左右依次是其左子树和右子树
 * 
 */

 /**
  * 版本1
  * 是递归解法,但是在inorder序列中查找根节点时暴力查找,时间浪费大
  */
// class Solution {
//     private TreeNode helper(List<Integer> inList, List<Integer> preList) {
//         int val = preList.remove(0);
//         TreeNode node = new TreeNode(val);
//         int index = inList.indexOf(val);
//         if (index != 0) {
//             node.left = helper(inList.subList(0, index), preList);
//         }
//         if (index != inList.size() - 1) {
//             node.right = helper(inList.subList(index + 1, inList.size()), preList);
//         }
//         return node;
//     };

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if (inorder == null || inorder.length == 0) {
//             return null;
//         }
//         List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
//         List<Integer> preList = Arrays.stream(preorder).boxed().collect(Collectors.toList());

//         return helper(inList, preList);
//     }
// }

/**版本2
 * 依旧是递归版本,但是在查找中序序列中的根节点时使用了哈希,相对更快.
 */
class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left>preorder_right){
            // 相等时是叶子节点
            return null;
        }
        int preRoot = preorder_left;
        int inRoot = indexMap.get(preorder[preRoot]);

        TreeNode node = new TreeNode(preorder[preRoot]);
        int size_left_tree = inRoot - inorder_left;
        node.left = myBuildTree(preorder, inorder, preorder_left+1, preorder_left+size_left_tree, inorder_left, inRoot-1);
        node.right = myBuildTree(preorder, inorder, preorder_left+size_left_tree+1, preorder_right, inRoot+1, inorder_right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        indexMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }
}

// @lc code=end
