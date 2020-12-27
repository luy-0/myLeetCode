import java.util.ArrayList;
import java.util.List;

public class Offer34 {
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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return ans;
    }

    void helper(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }
        helper(node.left, sum - node.val);
        helper(node.right, sum - node.val);
        path.remove(path.size() - 1);
        return;
    }
}