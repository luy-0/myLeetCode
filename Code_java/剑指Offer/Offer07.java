import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Offer07
 */
public class Offer07 {
    public static void main(String[] args) {

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

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        List<Integer> preList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        // [3,9,20,15,7]
        // [9,3,15,20,7]
        return helper(preList, inList);
    }

    TreeNode helper(List<Integer> preList, List<Integer> inList) {
        if (inList.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(preList.remove(0));
        int index = inList.indexOf(root.val);
        root.left = helper(preList, inList.subList(0, index));
        root.right = helper(preList, inList.subList(1 + index, inList.size()));
        return root;
    }
}