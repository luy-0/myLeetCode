public class Offer27 {
    
}

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode node = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        root.left = node;
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}